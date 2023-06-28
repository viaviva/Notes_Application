package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.ui.addNote.AddNoteFragment
import com.example.notes.ui.allNotes.AllNotesFragment
import com.example.notes.ui.profile.ProfileFragment
import com.example.notes.ui.searchNote.SearchNoteFragment

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.beginTransaction()
            .replace(R.id.container, AllNotesFragment())
            .commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.allNotesItem -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, AllNotesFragment())
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.addNotesItem -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, AddNoteFragment())
                        .addToBackStack("AddNoteFragment")
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.searchNotesItem -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchNoteFragment())
                        .addToBackStack("SearchNoteFragment")
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.profileItem -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .addToBackStack("ProfileFragment")
                        .commit()
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener true
            }
        }
    }
}