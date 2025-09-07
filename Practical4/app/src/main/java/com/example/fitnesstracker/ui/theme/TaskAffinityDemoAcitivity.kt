package com.example.fitnesstracker

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class TaskAffinityDemoActivity : ComponentActivity() {
    private val TAG = "TaskAffinityDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logTaskInfo()

        setContent {
            MaterialTheme {
                TaskAffinityDemoScreen()
            }
        }
    }

    private fun logTaskInfo() {
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val taskInfo = activityManager.getRunningTasks(10)

        Log.d(TAG, "Current Task ID: ${taskId}")
        Log.d(TAG, "Activity: ${this.javaClass.simpleName}")
        Log.d(TAG, "Running Tasks: ${taskInfo.size}")

        taskInfo.forEachIndexed { index, task ->
            Log.d(TAG, "Task $index: ${task.baseActivity?.className} (ID: ${task.id})")
        }
    }

    @Composable
    fun TaskAffinityDemoScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Task Affinity Demo",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Each button opens an activity in a different task. Check recent apps to see separate tasks!",
                style = MaterialTheme.typography.bodyMedium
            )

            // Button to open main task activity
            Button(
                onClick = {
                    startActivity(Intent(this@TaskAffinityDemoActivity, MainActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Open Main Task (Fitness)")
            }

            // Button to open summary task
            Button(
                onClick = {
                    startActivity(Intent(this@TaskAffinityDemoActivity, SummaryActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Open Summary Task (Separate)")
            }

            // Button to open data task
            Button(
                onClick = {
                    startActivity(Intent(this@TaskAffinityDemoActivity, DataPersistenceActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Open Data Task (Separate)")
            }

            // Button to open secondary task
            Button(
                onClick = {
                    startActivity(Intent(this@TaskAffinityDemoActivity, SecondActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Open Secondary Task (Separate)")
            }

            Divider()

            Text(
                text = "Task Affinity Behaviors:",
                style = MaterialTheme.typography.titleMedium
            )

            Card {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("• Main & Workout: Same task stack")
                    Text("• Summary: Separate task (singleTask)")
                    Text("• Data: Separate task (singleInstance)")
                    Text("• Secondary: Separate task")
                    Text("• Check recent apps to see multiple entries")
                }
            }
        }
    }
}