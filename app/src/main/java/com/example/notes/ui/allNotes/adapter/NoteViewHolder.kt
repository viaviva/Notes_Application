package com.example.notes.ui.allNotes.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notes.model.Note
import com.example.notes.R
import com.example.notes.databinding.ItemNoteBinding
import com.example.notes.util.getDate
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class NoteViewHolder(private val binding: ItemNoteBinding) : ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.run {
            titleText.text = note.title
            dateText.text =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(note.date), ZoneOffset.UTC).getDate()
            messageText.text = note.message
        }
    }
}