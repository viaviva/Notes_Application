package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        findViewById<TextView>(R.id.skipText).run {
            setOnClickListener {
                startActivity(Intent(this@OnboardingActivity, SignUpActivity::class.java))
            }
        }
    }
}