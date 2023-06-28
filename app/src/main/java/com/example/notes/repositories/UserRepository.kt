package com.example.notes.repositories

import com.example.notes.db.DataBase
import com.example.notes.model.User
import com.example.notes.util.toUserEntity

class UserRepository {

    fun addUser(user: User) = DataBase.userDao?.insertUser(user.toUserEntity())

    fun getUser(email: String, password: String): Boolean {
        return DataBase.userDao?.getUser(email, password) == null
    }

    fun getUserByEmail(email: String): Boolean {
        return DataBase.userDao?.getUserByEmail(email) == null
    }

    fun deleteUser(email: String) = DataBase.userDao?.run {
        deleteUser(
            getUserByEmail(email)
        )
    }
}