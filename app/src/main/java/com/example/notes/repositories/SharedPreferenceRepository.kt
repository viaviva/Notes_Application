package com.example.notes.repositories

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val SHARED_PREF_FILE = "sharedPrefFile"
private const val USER_PREF_FILE = "userPrefFile"

private const val IS_FIRST_OPEN = "isFirstOpen"
private const val IS_USER_LOG_IN = "isLogIn"
private const val USER_EMAIL = "userEmail"

private const val DEFAULT_USER_EMAIL = "email"

object SharedPreferenceRepository {

    private var sharedPreferences: SharedPreferences? = null
    private var userPreferences: SharedPreferences? = null

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)
        userPreferences = context.getSharedPreferences(USER_PREF_FILE, Context.MODE_PRIVATE)
    }

    fun setIsFirstOpen(isFirstOpen: Boolean) {
        sharedPreferences?.edit {
            putBoolean(IS_FIRST_OPEN, isFirstOpen)
        }
    }

    fun getIsFirstOpen(): Boolean = sharedPreferences?.getBoolean(IS_FIRST_OPEN, false) ?: false

    fun setIsUserLogIn(isUserLogIn: Boolean) {
        userPreferences?.edit {
            putBoolean(IS_USER_LOG_IN, isUserLogIn)
        }
    }

    fun getIsUserLogIn(): Boolean = userPreferences?.getBoolean(IS_USER_LOG_IN, false) ?: false

    fun setUserEmail(userEmail: String) {
        userPreferences?.edit {
            putString(USER_EMAIL, userEmail)
        }
    }

    fun getUserEmail(): String =
        userPreferences?.getString(USER_EMAIL, DEFAULT_USER_EMAIL) ?: DEFAULT_USER_EMAIL

    fun clearUserPreference() {
        userPreferences?.edit {
            clear()
        }
    }
}