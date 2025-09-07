package com.example.fitnesstracker

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class DataPersistenceActivity : ComponentActivity() {
    private val TAG = "DataPersistence"

    // Keys for saved state
    companion object {
        private const val KEY_EMAIL = "user_email"
        private const val KEY_NAME = "user_name"
        private const val KEY_PHONE = "user_phone"
        private const val KEY_COUNTER = "counter_value"
    }

    // State variables that need to persist
    private var userEmail by mutableStateOf("")
    private var userName by mutableStateOf("")
    private var userPhone by mutableStateOf("")
    private var counterValue by mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Restore saved data
        savedInstanceState?.let { bundle ->
            userEmail = bundle.getString(KEY_EMAIL, "")
            userName = bundle.getString(KEY_NAME, "")
            userPhone = bundle.getString(KEY_PHONE, "")
            counterValue = bundle.getInt(KEY_COUNTER, 0)

            Log.d(TAG, "Data restored - Email: $userEmail, Name: $userName, Counter: $counterValue")
        }

        setContent {
            MaterialTheme {
                DataPersistenceScreen()
            }
        }
    }

    // Save data when configuration changes (rotation, etc.)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save all important data
        outState.putString(KEY_EMAIL, userEmail)
        outState.putString(KEY_NAME, userName)
        outState.putString(KEY_PHONE, userPhone)
        outState.putInt(KEY_COUNTER, counterValue)

        Log.d(TAG, "Data saved - Email: $userEmail, Name: $userName, Counter: $counterValue")
    }

    @Composable
    fun DataPersistenceScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Data Persistence Demo",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Rotate your device to test data persistence!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Email input
            OutlinedTextField(
                value = userEmail,
                onValueChange = { userEmail = it },
                label = { Text("Email Address") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            // Name input
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Phone input
            OutlinedTextField(
                value = userPhone,
                onValueChange = { userPhone = it },
                label = { Text("Phone Number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )

            // Counter section
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Counter: $counterValue",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(onClick = { counterValue++ }) {
                            Text("+")
                        }
                        Button(onClick = { counterValue-- }) {
                            Text("-")
                        }
                        Button(onClick = { counterValue = 0 }) {
                            Text("Reset")
                        }
                    }
                }
            }

            // Display current data
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Current Data:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Email: ${userEmail.ifEmpty { "Not entered" }}")
                    Text("Name: ${userName.ifEmpty { "Not entered" }}")
                    Text("Phone: ${userPhone.ifEmpty { "Not entered" }}")
                    Text("Counter: $counterValue")
                }
            }
        }
    }
}