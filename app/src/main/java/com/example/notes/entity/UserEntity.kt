package com.example.notes.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(

    @ColumnInfo(name = "firstName")
    val firstName: String,

    @ColumnInfo(name = "lastName")
    val lastName: String,

    @PrimaryKey
    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String

)