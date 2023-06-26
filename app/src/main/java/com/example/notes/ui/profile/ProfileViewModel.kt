package com.example.notes.ui.profile

import androidx.lifecycle.ViewModel
import com.example.notes.repositories.UserRepository

class ProfileViewModel: ViewModel() {
    private val userRepository = UserRepository()

    fun deleteProfile(email: String) = userRepository.deleteUser(email)
}