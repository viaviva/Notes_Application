package com.example.notes.ui.searchNote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.model.Note
import com.example.notes.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val listOfNotes = MutableLiveData<List<Note>>()

    fun getListOfNotes(value: String) {
        if (value.isNotEmpty()) {
            listOfNotes.value = noteRepository.searchNotes("%$value%")
        } else {
            listOfNotes.value = listOf()
        }
    }

}