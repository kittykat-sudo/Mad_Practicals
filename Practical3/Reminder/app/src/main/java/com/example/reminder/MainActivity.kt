package com.example.reminder

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var welcomeText: TextView
    private lateinit var reminderText: TextView
    private lateinit var updateReminderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "App started - onCreate called")

        setContentView(R.layout.activity_main)

        initializeViews()

        welcomeText.text = getString(R.string.welcome_msg)

        setupClickListeners()
    }

    private fun initializeViews() {
        welcomeText = findViewById(R.id.welcomeText)
        reminderText = findViewById(R.id.reminderText)
        updateReminderButton = findViewById(R.id.updateReminderButton)
    }

    private fun setupClickListeners() {
        // Method 1: Using View.OnClickListener interface
        updateReminderButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                reminderText.text = getString(R.string.updated_reminder)
                Log.d("MainActivity", "Reminder updated using OnClickListener interface")
            }
        })

        // Method 2: Using Kotlin lambda (SAM) - Comment out Method 1 to use this
        /*
        updateReminderButton.setOnClickListener { view ->
            reminderText.text = getString(R.string.updated_reminder)
            Log.d("MainActivity", "Reminder updated using Kotlin lambda")
        }
        */

        // Even simpler lambda version
        /*
        updateReminderButton.setOnClickListener {
            reminderText.text = getString(R.string.updated_reminder)
            Log.d("MainActivity", "Reminder updated using simple lambda")
        }
        */
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
    }
}