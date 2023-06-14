package com.example.notes.ui.allNotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.model.Note
import com.example.notes.repositories.NoteRepository

class AllNotesViewModel : ViewModel() {

    val listOfNotes = MutableLiveData<ArrayList<Note>>()

    private val noteRepository = NoteRepository()

    fun getListOfNotes() {
        listOfNotes.value = noteRepository.getListOfNotes()
    }
}