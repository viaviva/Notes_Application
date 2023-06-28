package com.example.notes.ui.allNotes.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notes.model.Note
import com.example.notes.databinding.ItemNoteBinding
import com.example.notes.util.longToDate

class NoteViewHolder(private val binding: ItemNoteBinding) : ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.run {
            titleText.text = note.title
            dateText.text = longToDate(note.date)
            messageText.text = note.message
        }
    }
}