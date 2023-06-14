package com.example.notes.ui.allNotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.ui.allNotes.adapter.NoteAdapter
import com.example.notes.databinding.FragmentAllNotesBinding
import com.example.notes.model.Note

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
                adapter = NoteAdapter()
            }
            (adapter as? NoteAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }
}
