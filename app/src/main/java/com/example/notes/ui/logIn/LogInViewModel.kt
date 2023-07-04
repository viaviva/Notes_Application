package com.example.notes.ui.logIn

import androidx.lifecycle.ViewModel
import com.example.notes.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser(email: String, password: String) = userRepository.getUser(email, password)
}