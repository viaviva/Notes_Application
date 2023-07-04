package com.example.notes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.R
import com.example.notes.repositories.SharedPreferenceRepository
import com.example.notes.ui.logIn.LogInFragment
import com.example.notes.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferenceRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences.run {
            if (getIsFirstOpen()) {
                if (getIsUserLogIn()) {
                    supportFragmentManager.replaceFragment(R.id.main_container, HomeFragment())
                } else {
                    supportFragmentManager.replaceFragment(R.id.main_container, LogInFragment())
                }
            } else {
                setIsFirstOpen()
                supportFragmentManager.replaceFragment(R.id.main_container, MainFragment())
            }
        }
    }

}