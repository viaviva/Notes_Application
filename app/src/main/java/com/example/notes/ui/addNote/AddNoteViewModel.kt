package com.example.notes.ui.addNote

import androidx.lifecycle.ViewModel
import com.example.notes.model.Note
import com.example.notes.repositories.NoteRepository

class AddNoteViewModel : ViewModel() {

    private val noteRepository = NoteRepository()

    fun addNote(note: Note, onClick: Unit) {
        noteRepository.addNote(note)
        return onClick
    }
}
