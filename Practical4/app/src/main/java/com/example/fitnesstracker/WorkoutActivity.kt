package com.example.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class WorkoutActivity : BaseActivity() {
    private val TAG = "WorkoutActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        Log.d(TAG, "onCreate - Workout screen created")

        findViewById<Button>(R.id.btnToHome).setOnClickListener {
            Log.d(TAG, "Navigating to Home screen")
            startActivity(Intent(this, MainActivity::class.java))
        }

        findViewById<Button>(R.id.btnToSummary).setOnClickListener {
            Log.d(TAG, "Navigating to Summary screen")
            startActivity(Intent(this, SummaryActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart - Workout screen started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume - Workout screen resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause - Workout screen paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop - Workout screen stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy - Workout screen destroyed")
    }
}