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

    @Query("SELECT * FROM note WHERE user_email = :email")
    fun getAllNotes(email: String): List<NoteEntity>

    @Query("SELECT * FROM note WHERE user_email = :email AND (title LIKE :value OR message LIKE :value)")
    fun searchNotes(value: String, email: String): List<NoteEntity>

    @Query("DELETE FROM note WHERE user_email = :email")
    fun deleteAllNotes(email: String)

}