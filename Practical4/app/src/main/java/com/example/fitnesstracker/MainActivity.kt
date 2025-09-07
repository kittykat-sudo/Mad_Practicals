package com.example.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstracker.ui.theme.FitnesstrackerTheme

class MainActivity : BaseActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate - Home screen created")

        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        // Navigate to Workout Activity
        findViewById<Button>(R.id.btnToWorkout)?.setOnClickListener {
            Log.d(TAG, "Navigating to Workout screen")
            startActivity(Intent(this, WorkoutActivity::class.java))
        }

        // Navigate to Summary Activity
        findViewById<Button>(R.id.btnToSummary)?.setOnClickListener {
            Log.d(TAG, "Navigating to Summary screen")
            startActivity(Intent(this, SummaryActivity::class.java))
        }

        // Navigate to Second Activity (Back button demo)
        findViewById<Button>(R.id.btnToSecond)?.setOnClickListener {
            Log.d(TAG, "Navigating to Second Activity")
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // Navigate to Compose Activity
        findViewById<Button>(R.id.btnToCompose)?.setOnClickListener {
            Log.d(TAG, "Navigating to Compose Activity")
            startActivity(Intent(this, ComposeActivity::class.java))
        }

        // Navigate to Data Persistence Activity
        findViewById<Button>(R.id.btnToDataPersistence)?.setOnClickListener {
            Log.d(TAG, "Navigating to Data Persistence Activity")
            startActivity(Intent(this, DataPersistenceActivity::class.java))
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState - Saving state")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState - Restoring state")
    }
}

// Enhanced Greeting Composable for Fitness Tracker
@Composable
fun FitnessGreeting(name: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "🏋️ Fitness Tracker",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = "Welcome back, $name!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Ready to crush your fitness goals today?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}

// Navigation Menu Composable
@Composable
fun NavigationMenu(
    onWorkoutClick: () -> Unit,
    onSummaryClick: () -> Unit,
    onSecondClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Navigation Menu",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Workout Button
        Button(
            onClick = onWorkoutClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "🏃‍♂️ Start Workout",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Summary Button
        Button(
            onClick = onSummaryClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(
                text = "📊 View Summary",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Second Activity Button
        OutlinedButton(
            onClick = onSecondClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "⚙️ Settings & Demo",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// Main Compose Screen (for future Compose-based implementation)
@Composable
fun MainScreen(
    userName: String = "Fitness Enthusiast",
    onWorkoutClick: () -> Unit = {},
    onSummaryClick: () -> Unit = {},
    onSecondClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        FitnessGreeting(name = userName)

        NavigationMenu(
            onWorkoutClick = onWorkoutClick,
            onSummaryClick = onSummaryClick,
            onSecondClick = onSecondClick
        )

        Spacer(modifier = Modifier.weight(1f))

        // Footer
        Text(
            text = "Track • Train • Transform",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// Updated Previews
@Preview(showBackground = true, name = "Fitness Greeting")
@Composable
fun FitnessGreetingPreview() {
    FitnesstrackerTheme {
        FitnessGreeting("Alex")
    }
}

@Preview(showBackground = true, name = "Navigation Menu")
@Composable
fun NavigationMenuPreview() {
    FitnesstrackerTheme {
        NavigationMenu(
            onWorkoutClick = {},
            onSummaryClick = {},
            onSecondClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Main Screen", showSystemUi = true)
@Composable
fun MainScreenPreview() {
    FitnesstrackerTheme {
        MainScreen()
    }
}

// Keep original for backward compatibility
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