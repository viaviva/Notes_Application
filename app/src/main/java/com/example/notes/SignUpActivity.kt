package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<TextView>(R.id.loginText).run {
            setOnClickListener {
                startActivity(Intent(this@SignUpActivity, LogInActivity::class.java))
            }
        }

        findViewById<Button>(R.id.signUpButton).run {
            setOnClickListener {
                startActivity(Intent(this@SignUpActivity, AllNotesActivity::class.java))
            }
        }
    }
}