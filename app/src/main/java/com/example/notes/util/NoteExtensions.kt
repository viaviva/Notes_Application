package com.example.notes.util

import com.example.notes.entity.NoteEntity
import com.example.notes.model.Note

fun List<NoteEntity>.listToNote() = map {
    Note(
        it.id,
        it.title,
        it.message,
        it.date
    )
}

fun Note.toNoteEntity(email: String) =
    NoteEntity(
        id,
        title,
        message,
        date,
        email
    )