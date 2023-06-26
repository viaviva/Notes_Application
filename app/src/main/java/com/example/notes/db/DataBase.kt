package com.example.notes.db

import android.content.Context
import androidx.room.Room
import com.example.notes.model.Note

object DataBase {

    private var dataBase: AppDataBase? = null

    var noteDao: NoteDao? = null
    var userDao: UserDao? = null
    fun initDB(context: Context) {
        dataBase = Room.databaseBuilder(context, AppDataBase::class.java, "database")
            .allowMainThreadQueries()
            .build()
        noteDao = dataBase?.getNoteDao()
        userDao = dataBase?.getUserDao()
    }

    val listOfNotes: ArrayList<Note> =
        arrayListOf(Note("Kyle Wilson", "Awesome job!", 1417601730000))
}