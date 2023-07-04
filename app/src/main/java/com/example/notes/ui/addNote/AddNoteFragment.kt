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
import dagger.hilt.android.AndroidEntryPoint
import java.time.Instant

@AndroidEntryPoint
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

        viewModel.run {
            noteSaved = {
                binding.root.post {
                    Toast.makeText(requireContext(), R.string.note_saved, Toast.LENGTH_LONG).show()
                }
            }

            noteNotSaved = {
                binding.root.post {
                    Toast.makeText(requireContext(), R.string.note_not_saved, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
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
                0,
                binding.titleTextInputLayout.getText(),
                binding.messageTextInputLayout.getText(),
                Instant.now().toEpochMilli()
            )
        )
    }

    private fun isTitleValidate(): Boolean {

        return when (val titleValidationResult =
            titleValidation(binding.titleTextInputLayout.getText())) {
            is ValidationResult.Invalid -> {
                binding.titleTextInputLayout.error =
                    requireContext().getString(titleValidationResult.errorId)
                false
            }

            else -> {
                binding.titleTextInputLayout.error = null
                true
            }
        }
    }
}
