package com.example.notes.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notes.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String): UserEntity

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserByEmail(email: String): UserEntity
}