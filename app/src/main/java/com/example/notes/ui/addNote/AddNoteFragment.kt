package com.example.notes.ui.addNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.model.Note
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNoteBinding
import com.example.notes.util.getText
import com.example.notes.validation.ValidationResult
import com.example.notes.validation.titleValidation
import java.time.Instant

class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding

    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            titleTextInputEditText.addTextChangedListener(
                afterTextChanged = {
                    addNewButton.isClickable = isTitleValidate()
                }
            )
        }

        binding.addNewButton.setOnClickListener {
            addNote()
            parentFragmentManager.popBackStack()
        }
    }

    private fun addNote() {
        viewModel.addNote(
            Note(
                binding.titleTextInputLayout.getText(),
                binding.messageTextInputLayout.getText(),
                Instant.now().toEpochMilli()
            ),
            Toast.makeText(requireContext(), R.string.note_saved, Toast.LENGTH_LONG).show()
        )
    }

    private fun isTitleValidate(): Boolean {
        val titleValidationResult = titleValidation(binding.titleTextInputLayout.getText())

        when (titleValidationResult) {
            is ValidationResult.Invalid -> {
                binding.titleTextInputLayout.error =
                    requireContext().getString(titleValidationResult.errorId)
                return false
            }

            else -> {
                binding.titleTextInputLayout.error = null
                return true
            }
        }
    }
}
