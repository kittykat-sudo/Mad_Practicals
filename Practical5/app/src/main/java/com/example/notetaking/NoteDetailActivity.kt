package com.example.notetaking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        // Accessing the passed data
        val noteId = intent.getStringExtra("NOTE_ID")
        val noteTitle = intent.getStringExtra("NOTE_TITLE")

        if (noteId != null) {
            loadNoteDetails(noteId)
        }
    }

    private fun loadNoteDetails(noteId: String) {
        // Load note details using the ID
    }
}