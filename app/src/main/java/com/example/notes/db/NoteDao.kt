package com.example.notes.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notes.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<NoteEntity>

    @Query("SELECT * FROM note WHERE title LIKE :value OR message LIKE :value")
    fun searchNotes(value: String): List<NoteEntity>

}