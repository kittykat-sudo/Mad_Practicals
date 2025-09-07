package com.yourpackage.sensorapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SensorInfoActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        displayAccelerometerInfo()
    }

    private fun displayAccelerometerInfo() {
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        
        if (accelerometer != null) {
            Log.d("AccelerometerInfo", "=== ACCELEROMETER DETAILS ===")
            Log.d("AccelerometerInfo", "Sensor Name: ${accelerometer.name}")
            Log.d("AccelerometerInfo", "Vendor: ${accelerometer.vendor}")
            Log.d("AccelerometerInfo", "Power Usage: ${accelerometer.power} mA")
            Log.d("AccelerometerInfo", "Resolution: ${accelerometer.resolution} m/s²")
            Log.d("AccelerometerInfo", "Maximum Range: ${accelerometer.maximumRange} m/s²")
            Log.d("AccelerometerInfo", "Minimum Delay: ${accelerometer.minDelay} μs")
            Log.d("AccelerometerInfo", "Type: ${accelerometer.type}")
            Log.d("AccelerometerInfo", "Version: ${accelerometer.version}")
            
            // Additional mock information for demonstration
            Log.d("AccelerometerInfo", "=== MOCK ADDITIONAL INFO ===")
            Log.d("AccelerometerInfo", "Sample Rate: 50 Hz")
            Log.d("AccelerometerInfo", "Operating Temperature: -40°C to +85°C")
            Log.d("AccelerometerInfo", "Accuracy: ±0.01 m/s²")
        } else {
            Log.e("AccelerometerInfo", "Accelerometer not available on this device")
        }
    }
}