package com.wj.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GpsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)
        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        button1.setOnClickListener {
            startService(Intent(this, MyLocationService::class.java))
        }
        button2.setOnClickListener {
            stopService(Intent(this, MyLocationService::class.java))
        }
    }
}