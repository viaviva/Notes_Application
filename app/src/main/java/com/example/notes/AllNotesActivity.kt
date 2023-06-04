package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.adapter.NoteAdapter
import com.example.notes.db.DataBase

class AllNotesActivity : AppCompatActivity(), Subscriber {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_notes)
        DataBase.subscribe(this)

        findViewById<Button>(R.id.addButton).run {
            setOnClickListener {
                startActivity(Intent(this@AllNotesActivity, AddNoteActivity::class.java))
            }
        }

        recyclerView = findViewById(R.id.recyclerViewNotes)

        recyclerView?.run {
            layoutManager = LinearLayoutManager(this@AllNotesActivity)
            adapter = NoteAdapter()
            (adapter as? NoteAdapter)?.submitList(DataBase.getListOfNotes())
        }
    }

    override fun update() {
        recyclerView?.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(this@AllNotesActivity)
                adapter = NoteAdapter()
            }
            (adapter as? NoteAdapter)?.submitList(DataBase.getListOfNotes())
            adapter?.notifyDataSetChanged()
        }
    }
}