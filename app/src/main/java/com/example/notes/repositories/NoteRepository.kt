package com.example.notes.repositories

import com.example.notes.db.DataBase
import com.example.notes.entity.NoteEntity
import com.example.notes.model.Note

class NoteRepository {

    fun getListOfNotes(): ArrayList<Note> {
        return (DataBase.noteDao?.getAllNotes()?.map {
            Note(
                it.title,
                it.message,
                it.date
            )
        } as? ArrayList<Note>) ?: arrayListOf()
    }

    fun addNote(note: Note) = DataBase.noteDao?.insertNote(
        NoteEntity(
            0,
            note.title,
            note.message,
            note.date
        )
    )

    fun get() = DataBase.listOfNotes.filter {
        it.title.contains("a") or it.message.contains("a")
    }.distinct()

    fun searchNotes(value: String): List<Note> {
        return DataBase.listOfNotes.filter {
            it.title.contains(value)
        }
    }

}