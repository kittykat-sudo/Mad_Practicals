package com.example.fitnesstracker

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Modern way to handle back button (recommended)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitConfirmationDialog()
            }
        })
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
            .setCancelable(false) // Prevent dismissing by tapping outside
            .show()
    }

    // Legacy approach (still works but not recommended for new code)
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        showExitConfirmationDialog()
        // Don't call super.onBackPressed() here to prevent default behavior
    }
}