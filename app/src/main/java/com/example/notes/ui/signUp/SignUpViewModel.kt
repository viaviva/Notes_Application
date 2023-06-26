package com.example.notes.ui.signUp

import androidx.lifecycle.ViewModel
import com.example.notes.model.User
import com.example.notes.repositories.UserRepository

class SignUpViewModel: ViewModel() {

    private val userRepository = UserRepository()

    fun addUser(user: User) = userRepository.addUser(user)

    fun getUserByEmail(email: String) = userRepository.getUserByEmail(email)
}