package com.example.notes.ui.allNotes

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.R
import com.example.notes.ui.allNotes.adapter.NoteAdapter
import com.example.notes.databinding.FragmentAllNotesBinding
import com.example.notes.model.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllNotesFragment : Fragment() {

    private lateinit var binding: FragmentAllNotesBinding

    private val viewModel: AllNotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            noteDeleted = {
                binding.root.post {
                    Toast.makeText(requireContext(), R.string.note_deleted, Toast.LENGTH_LONG)
                        .show()
                }
            }

            noteNotDeleted = {
                binding.root.post {
                    Toast.makeText(requireContext(), R.string.note_not_deleted, Toast.LENGTH_LONG)
                        .show()
                }
            }

            listOfNotes.observe(viewLifecycleOwner) {
                initRecyclerView(it)
            }
            getListOfNotes()
        }
    }

    private fun initRecyclerView(list: ArrayList<Note>) {
        binding.recyclerViewNotes.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NoteAdapter { view, note ->
                    showPopup(view, note)
                }
            }
            (adapter as? NoteAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun showPopup(v: View, note: Note) {
        val popup = PopupMenu(requireContext(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_note_item, popup.menu)

        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.delete -> {
                    showDeleteDialog(note)
                }
            }
            return@setOnMenuItemClickListener true
        }
        popup.show()
    }

    private fun showDeleteDialog(note: Note) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.delete_note)
            .setPositiveButton(R.string.yes) { _, _ ->
                viewModel.deleteNote(note)
            }
            .setNegativeButton(R.string.no) { _, _ ->

            }
            .show()
    }
}
