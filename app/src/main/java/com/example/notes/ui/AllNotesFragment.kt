package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.Subscriber
import com.example.notes.adapter.NoteAdapter
import com.example.notes.databinding.FragmentAllNotesBinding
import com.example.notes.db.DataBase

class AllNotesFragment : Fragment(), Subscriber {

    private lateinit var recyclerView: RecyclerView

    private lateinit var binding: FragmentAllNotesBinding

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

        DataBase.subscribe(this)

        recyclerView = binding.recyclerViewNotes
        initRecyclerView()
    }

    override fun update() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NoteAdapter()
            }
            (adapter as? NoteAdapter)?.submitList(DataBase.getListOfNotes())
            adapter?.notifyDataSetChanged()
        }
    }
}
