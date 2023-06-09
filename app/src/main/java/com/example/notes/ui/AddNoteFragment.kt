package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notes.Note
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNoteBinding
import com.example.notes.db.DataBase
import com.example.notes.util.getText
import java.time.Instant

class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding

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

        binding.addNewButton.setOnClickListener {
            DataBase.addNote(
                Note(
                    binding.titleTextInputLayout.getText(),
                    binding.messageTextInputLayout.getText(),
                    Instant.now().toEpochMilli()
                )
            )
            Toast.makeText(requireContext(), R.string.note_saved, Toast.LENGTH_LONG).show()
            parentFragmentManager.popBackStack()
        }
    }
}
