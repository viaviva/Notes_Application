package com.example.notes

import android.app.Application
import com.example.notes.db.DataBase
import com.example.notes.repositories.SharedPreferenceRepository

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DataBase.initDB(applicationContext)
        SharedPreferenceRepository.init(applicationContext)
    }
}