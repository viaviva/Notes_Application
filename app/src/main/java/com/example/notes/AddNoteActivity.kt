package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.db.DataBase
import com.example.notes.util.getDate
import com.example.notes.util.getText
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        findViewById<TextView>(R.id.backTextView).run {
            setOnClickListener {
                startActivity(Intent(this@AddNoteActivity, AllNotesActivity::class.java))
            }
        }

        val titleTextInputLayout =
            findViewById<TextInputLayout>(R.id.titleTextInputLayout)
        val messageTextInputLayout =
            findViewById<TextInputLayout>(R.id.messageTextInputLayout)

        findViewById<Button>(R.id.addNewButton).run {
            setOnClickListener {
                DataBase.addNote(
                    Note(
                        titleTextInputLayout.getText(),
                        messageTextInputLayout.getText(),
                        LocalDate.now().getDate()
                    )
                )

                Toast.makeText(this@AddNoteActivity, R.string.note_saved, Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}