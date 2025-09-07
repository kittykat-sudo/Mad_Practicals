package com.example.fitnesstracker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "${this.javaClass.simpleName} resumed", Toast.LENGTH_SHORT).show()
    }
}