package com.example.fitnesstracker

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class SummaryActivity : BaseActivity() {
    private val TAG = "SummaryActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        Log.d(TAG, "onCreate - Summary screen created")

        findViewById<Button>(R.id.btnToHome).setOnClickListener {
            Log.d(TAG, "Navigating to Home screen")
            startActivity(Intent(this, MainActivity::class.java))
        }

        findViewById<Button>(R.id.btnToWorkout).setOnClickListener {
            Log.d(TAG, "Navigating to Workout screen")
            startActivity(Intent(this, WorkoutActivity::class.java))
        }
    }

    // Override back button behavior with confirmation dialog
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit Summary")
            .setMessage("Are you sure you want to leave the summary?")
            .setPositiveButton("Yes") { _, _ ->
                Log.d(TAG, "User confirmed back navigation")
                super.onBackPressed()
            }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart - Summary screen started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume - Summary screen resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause - Summary screen paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop - Summary screen stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy - Summary screen destroyed")
    }
}