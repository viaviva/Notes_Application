package com.example.notes.db

import com.example.notes.Note
import com.example.notes.Subscriber

object DataBase {

    private val listOfNotes: ArrayList<Note> =
        arrayListOf(Note("Kyle Wilson", "Awesome job!", "20/06/2023"))

    private val listOfSubscribers = arrayListOf<Subscriber>()

    fun getListOfNotes() = listOfNotes

    fun addNote(note: Note) {
        listOfNotes.add(note)
        notifySubscribers()
    }

    fun subscribe(s: Subscriber) = listOfSubscribers.add(s)

    fun unsubscribe(s: Subscriber) = listOfSubscribers.remove(s)

    private fun notifySubscribers() {
        listOfSubscribers.forEach {
            it.update()
        }
    }
}