package com.example.notes.ui.searchNote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.model.Note
import com.example.notes.repositories.NoteRepository

class SearchNoteViewModel : ViewModel() {

    val listOfNotes = MutableLiveData<List<Note>>()

    private val noteRepository = NoteRepository()

    fun getListOfNotes(value: String) {
        if (value.isNotEmpty()) {
            listOfNotes.value = noteRepository.searchNotes("%$value%")
        }
        else {
            listOfNotes.value = listOf()
        }
    }
}