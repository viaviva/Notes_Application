package com.example.notes.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "note",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        childColumns = ["user_email"],
        parentColumns = ["email"]
    )]
)

data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "message")
    val message: String,

    @ColumnInfo(name = "date")
    val date: Long,

    @ColumnInfo(name = "user_email")
    val email: String
)