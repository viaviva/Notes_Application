package com.example.notes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.entity.NoteEntity
import com.example.notes.entity.UserEntity

@Database(
    entities = [NoteEntity::class, UserEntity::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    abstract fun getUserDao(): UserDao
}