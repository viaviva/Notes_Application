package com.example.notes.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.repositories.NoteRepository
import com.example.notes.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository
) : ViewModel() {

    val countOfNotes = MutableLiveData<Int>()

    fun deleteProfile() = userRepository.deleteUser()

    var allNotesDeleted: (() -> Unit)? = null

    fun getCountOfNotes() {
        countOfNotes.value = noteRepository.getListOfNotes().size
    }

    fun deleteAllNotes() {
        if (noteRepository.deleteAllNotes()) {
            allNotesDeleted?.invoke()
        }
    }

}