package com.example.notes.repositories

import com.example.notes.db.UserDao
import com.example.notes.model.User
import com.example.notes.util.toUserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val sharedPreferences: SharedPreferenceRepository
) {

    fun addUser(user: User) = userDao.insertUser(user.toUserEntity())

    fun getUser(email: String, password: String): Boolean {
        return userDao.getUser(email, password) == null
    }

    fun getUserByEmail(email: String): Boolean {
        return userDao.getUserByEmail(email) == null
    }

    fun deleteUser() = userDao.run {
        deleteUser(
            getUserByEmail(sharedPreferences.getUserEmail())
        )
    }
}