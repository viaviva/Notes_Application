package com.example.notes.repositories

import com.example.notes.db.DataBase
import com.example.notes.entity.UserEntity
import com.example.notes.model.User

class UserRepository {

    fun addUser(user: User) = DataBase.userDao?.insertUser(
        UserEntity(
            0,
            user.firstName,
            user.lastName,
            user.email,
            user.password
        )
    )

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