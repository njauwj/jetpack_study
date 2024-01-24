package com.wj.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private val chronometer by lazy {
        findViewById<Chronometer>(R.id.chronometer)
    }

    private var elapsedTime: Long = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        //SystemClock.elapsedRealtime() 返回自启动以来的毫秒数，包括睡眠时间
        // chronometer.base 设置递增计时器所参考的时间。
        chronometer.base = SystemClock.elapsedRealtime() - elapsedTime

        chronometer.start()
    }

    override fun onPause() {
        super.onPause()
        elapsedTime = SystemClock.elapsedRealtime() - chronometer.base
        chronometer.stop()
    }
}