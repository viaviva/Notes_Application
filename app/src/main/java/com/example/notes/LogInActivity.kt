package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        findViewById<TextView>(R.id.signupText).run {
            setOnClickListener {
                startActivity(Intent(this@LogInActivity, SignUpActivity::class.java))
            }
        }

        findViewById<Button>(R.id.logInButton).run {
            setOnClickListener {
                startActivity(Intent(this@LogInActivity, AllNotesActivity::class.java))
            }
        }
    }
}