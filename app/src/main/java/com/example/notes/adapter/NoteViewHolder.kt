package com.example.notes.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notes.Note
import com.example.notes.R
import com.example.notes.util.getDate
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class NoteViewHolder(private val view: View) : ViewHolder(view) {

    fun bind(note: Note) {
        val title: TextView = view.findViewById(R.id.titleText)
        val date: TextView = view.findViewById(R.id.dateText)
        val message: TextView = view.findViewById(R.id.messageText)

        title.text = note.title
        date.text =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(note.date), ZoneOffset.UTC).getDate()
        message.text = note.message
    }
}