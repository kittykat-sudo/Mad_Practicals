package com.example.notetaking

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notetaking.ui.theme.NotetakingTheme

class MainActivity : AppCompatActivity() {

    private fun openNoteDetail(noteId: String) {
        val intent = Intent(this, NoteDetailActivity::class.java).apply {
            putExtra("NOTE_ID", noteId)
            putExtra("NOTE_TITLE", "Sample Note") // Optional additional data
        }
        startActivity(intent)
    }
    private fun sendEmailFeedback() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("feedback@noteapp.com"))
            putExtra(Intent.EXTRA_SUBJECT, "App Feedback")
            putExtra(Intent.EXTRA_TEXT, "Please share your feedback...")
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Send feedback via..."))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
        }
    }
}