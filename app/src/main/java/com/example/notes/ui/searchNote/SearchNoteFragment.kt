package com.example.notes.ui.searchNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.databinding.FragmentSearchNoteBinding
import com.example.notes.model.Note
import com.example.notes.ui.allNotes.adapter.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchNoteFragment : Fragment() {

    private lateinit var binding: FragmentSearchNoteBinding

    private val viewModel: SearchNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            listOfNotes.observe(viewLifecycleOwner) {
                initRecyclerView(it)
            }

            binding.searchInputEditText.addTextChangedListener(
                afterTextChanged = {
                    getListOfNotes(binding.searchInputEditText.text.toString())
                }
            )
        }
    }

    private fun initRecyclerView(list: List<Note>) {
        binding.recyclerViewSearchNotes.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NoteAdapter()
            }
            (adapter as? NoteAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }
}