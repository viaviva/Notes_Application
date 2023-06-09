package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.databinding.FragmentSearchNoteBinding

class SearchNoteFragment : Fragment() {

    private lateinit var binding: FragmentSearchNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

}