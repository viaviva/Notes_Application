package com.example.notes.ui.addNote

import androidx.lifecycle.ViewModel
import com.example.notes.model.Note
import com.example.notes.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
): ViewModel()  {

    var noteSaved: (() -> Unit)? = null

    var noteNotSaved: (() -> Unit)? = null

    fun addNote(note: Note) {
        if (noteRepository.addNote(note)) {
            noteSaved?.invoke()
        }
        else {
            noteNotSaved?.invoke()
        }
    }
}
