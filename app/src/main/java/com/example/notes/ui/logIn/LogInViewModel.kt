package com.example.notes.ui.logIn

import androidx.lifecycle.ViewModel
import com.example.notes.repositories.UserRepository

class LogInViewModel: ViewModel() {

    private val userRepository = UserRepository()

    fun getUser(email: String, password: String) = userRepository.getUser(email, password)
}