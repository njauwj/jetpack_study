package com.wj.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer

class MyChronometerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_chronometer)
        var myChronometer = findViewById<MyChronometer>(R.id.chronometer)
        lifecycle.addObserver(myChronometer)
    }

}