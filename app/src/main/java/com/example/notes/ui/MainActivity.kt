package com.example.notes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.R
import com.example.notes.repositories.SharedPreferenceRepository
import com.example.notes.ui.logIn.LogInFragment
import com.example.notes.util.replaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SharedPreferenceRepository.run {
            if (getIsFirstOpen()) {
                if(getIsUserLogIn()) {
                    supportFragmentManager.replaceFragment(R.id.main_container, HomeFragment())
                }
                else {
                    supportFragmentManager.replaceFragment(R.id.main_container, LogInFragment())
                }
            } else {
                setIsFirstOpen(true)
                supportFragmentManager.replaceFragment(R.id.main_container, MainFragment())
            }
        }
    }
}