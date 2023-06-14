package com.example.notes.repositories

import com.example.notes.db.NoteDataBase
import com.example.notes.model.Note

class NoteRepository {

    fun getListOfNotes() = NoteDataBase.listOfNotes

    fun addNote(note: Note) = NoteDataBase.listOfNotes.add(note)

    fun get() = NoteDataBase.listOfNotes.filter {
        it.title.contains("a") or it.message.contains("a")
    }.distinct()

    fun searchNotes(value: String): List<Note> {
        return NoteDataBase.listOfNotes.filter {
            it.title.contains(value)
        }
    }
}