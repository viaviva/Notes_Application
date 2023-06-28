package com.example.notes.repositories

import com.example.notes.db.DataBase
import com.example.notes.model.Note
import com.example.notes.util.listToNote
import com.example.notes.util.toNoteEntity

class NoteRepository {

    private val email = SharedPreferenceRepository.getUserEmail()

    fun getListOfNotes(): ArrayList<Note> {
        return (DataBase.noteDao?.getAllNotes(email)?.listToNote() as? ArrayList<Note>) ?: arrayListOf()
    }

    fun addNote(note: Note) = DataBase.noteDao?.insertNote(
        note.toNoteEntity(email)
    )

    fun searchNotes(value: String): ArrayList<Note> {
        return DataBase.noteDao?.searchNotes(value, email)?.listToNote() as ArrayList<Note>
    }

}