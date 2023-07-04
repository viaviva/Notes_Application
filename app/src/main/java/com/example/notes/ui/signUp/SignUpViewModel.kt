package com.example.notes.ui.signUp

import androidx.lifecycle.ViewModel
import com.example.notes.model.User
import com.example.notes.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun addUser(user: User) = userRepository.addUser(user)

    fun getUserByEmail(email: String) = userRepository.getUserByEmail(email)
}