package com.example.fitnesstracker

import android.os.Bundle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitnesstracker.ui.theme.FitnesstrackerTheme

import android.content.Intent
import android.util.Log
import android.widget.Button

class MainActivity : BaseActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate - Home screen created")

        findViewById<Button>(R.id.btnToWorkout).setOnClickListener {
            Log.d(TAG, "Navigating to Workout screen")
            startActivity(Intent(this, WorkoutActivity::class.java))
        }

        findViewById<Button>(R.id.btnToSummary).setOnClickListener {
            Log.d(TAG, "Navigating to Summary screen")
            startActivity(Intent(this, SummaryActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart - Home screen started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume - Home screen resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause - Home screen paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop - Home screen stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy - Home screen destroyed")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnesstrackerTheme {
        Greeting("Android")
    }
}