package com.example.notetaking

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class BatteryMonitorActivity : AppCompatActivity() {

    private val batteryReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
                val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
                val health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)
                val temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)
                val voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)

                val batteryPct = (level * 100 / scale.toFloat()).toInt()

                updateBatteryUI(batteryPct, status, health, temperature, voltage)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_monitor)

        setupToolbar()
        getCurrentBatteryInfo()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        try {
            unregisterReceiver(batteryReceiver)
        } catch (e: IllegalArgumentException) {
            // Receiver was not registered
        }
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getCurrentBatteryInfo() {
        val batteryStatus = registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        batteryStatus?.let { intent ->
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)
            val temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)
            val voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)

            val batteryPct = (level * 100 / scale.toFloat()).toInt()
            updateBatteryUI(batteryPct, status, health, temperature, voltage)
        }
    }

    private fun updateBatteryUI(
        batteryPercentage: Int,
        status: Int,
        health: Int,
        temperature: Int,
        voltage: Int
    ) {
        findViewById<TextView>(R.id.batteryLevel).text = "$batteryPercentage%"

        val statusText = when (status) {
            BatteryManager.BATTERY_STATUS_CHARGING -> "Charging"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> "Discharging"
            BatteryManager.BATTERY_STATUS_FULL -> "Full"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "Not Charging"
            else -> "Unknown"
        }
        findViewById<TextView>(R.id.tvBatteryStatus).text = statusText

        val healthText = when (health) {
            BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheating"
            BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
            BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
            else -> "Unknown"
        }
        findViewById<TextView>(R.id.tvBatteryHealth).text = healthText

        // Optional: Show additional info
        findViewById<TextView>(R.id.tvBatteryTemp)?.text = "${temperature / 10.0}°C"
        findViewById<TextView>(R.id.tvBatteryVoltage)?.text = "${voltage}mV"
    }
}