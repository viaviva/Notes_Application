package com.example.notes.util

import com.example.notes.entity.NoteEntity
import com.example.notes.model.Note

fun List<NoteEntity>.listToNote() = map {
    Note(
        it.title,
        it.message,
        it.date
    )
}

fun Note.toNoteEntity(email: String) = NoteEntity(
    0,
    title,
    message,
    date,
    email
)