package com.example.notes.ui.allNotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.model.Note
import com.example.notes.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllNotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val listOfNotes = MutableLiveData<ArrayList<Note>>()

    var noteDeleted: (() -> Unit)? = null

    var noteNotDeleted: (() -> Unit)? = null


    fun getListOfNotes() {
        listOfNotes.value = noteRepository.getListOfNotes()
    }

    fun deleteNote(note: Note) {
        if (noteRepository.deleteNote(note)) {
            getListOfNotes()
            noteDeleted?.invoke()
        } else {
            noteNotDeleted?.invoke()
        }
    }
}