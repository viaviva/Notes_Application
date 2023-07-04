package com.example.notes.repositories

import com.example.notes.db.NoteDao
import com.example.notes.model.Note
import com.example.notes.util.listToNote
import com.example.notes.util.toNoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    sharedPreferences: SharedPreferenceRepository
) {

    private val email = sharedPreferences.getUserEmail()

    fun getListOfNotes(): ArrayList<Note> {
        return (noteDao.getAllNotes(email).listToNote() as? ArrayList<Note>)
            ?: arrayListOf()
    }

    fun addNote(note: Note): Boolean {
        noteDao.insertNote(note.toNoteEntity(email))
        return true
    }

    fun searchNotes(value: String): ArrayList<Note> {
        return noteDao.searchNotes(value, email).listToNote() as ArrayList<Note>
    }

    fun deleteAllNotes(): Boolean {
        noteDao.deleteAllNotes(email)
        return true
    }

    fun deleteNote(note: Note): Boolean {
        noteDao.deleteNote(note.toNoteEntity(email))
        return true
    }

}