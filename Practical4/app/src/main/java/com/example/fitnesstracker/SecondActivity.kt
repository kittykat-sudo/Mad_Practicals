package com.example.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "SecondActivity created")

        // Set up button click listeners
        setupButtons()

        // Modern way to handle back button (recommended)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitConfirmationDialog()
            }
        })
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.btnBackToMain).setOnClickListener {
            Log.d(TAG, "Navigate to Main Activity")
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnTestBackButton).setOnClickListener {
            Log.d(TAG, "Test back button info shown")
            showInfoDialog()
        }
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
            .setTitle("Back Button Test")
            .setMessage("Now press the back button or use the back gesture to see the confirmation dialog in action!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setIcon(android.R.drawable.ic_dialog_info)
            .show()
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Confirm Exit")
            .setMessage("Are you sure you want to go back? Any unsaved changes will be lost.")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton("Yes") { dialog, _ ->
                Log.d(TAG, "User confirmed back navigation")
                dialog.dismiss()
                // Actually go back
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                Log.d(TAG, "User cancelled back navigation")
                dialog.dismiss()
            }
            .setNeutralButton("Cancel") { dialog, _ ->
                Log.d(TAG, "User pressed cancel")
                dialog.dismiss()
            }
            .setCancelable(false) // Prevent dismissing by tapping outside
            .show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondActivity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondActivity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondActivity destroyed")
    }
}