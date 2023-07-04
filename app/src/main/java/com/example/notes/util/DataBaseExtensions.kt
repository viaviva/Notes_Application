package com.example.notes.util

import android.content.Context
import androidx.room.Room
import com.example.notes.db.AppDataBase

fun Room.buildDB(context: Context) = databaseBuilder(context, AppDataBase::class.java, "database")
    .allowMainThreadQueries()
    .build()