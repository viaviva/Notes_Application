package com.example.notes.ui.allNotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.notes.databinding.ItemNoteBinding
import com.example.notes.model.Note

class NoteAdapter() : ListAdapter<Note, NoteViewHolder>(

    object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

) {

    private lateinit var binding: ItemNoteBinding

    private var onLongClick: ((itemView: View, note: Note) -> Unit)? = null

    constructor(
        onLongClick: (itemView: View, note: Note) -> Unit
    ) : this() {
        this.onLongClick = onLongClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            setLines(binding.messageText)
        }

        holder.itemView.setOnLongClickListener {
            onLongClick?.let { item -> item(it, getItem(position)) }
            return@setOnLongClickListener true
        }
    }

    private fun setLines(textView: TextView) {
        if (textView.maxLines == 1) {
            textView.maxLines = Int.MAX_VALUE
        } else {
            textView.maxLines = 1
        }
    }
}
