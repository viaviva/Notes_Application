package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.discoverButton).run {
            setOnClickListener {
                startActivity(Intent(this@MainActivity, OnboardingActivity::class.java))
            }
        }

        findViewById<TextView>(R.id.loginText).run {
            setOnClickListener {
                startActivity(Intent(this@MainActivity, LogInActivity::class.java))
            }
        }
    }
}