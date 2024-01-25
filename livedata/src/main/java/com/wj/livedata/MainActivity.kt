package com.wj.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    var myViewModel: MyViewModel? = null

    var textView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)
        var viewModelProvider =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
        myViewModel = viewModelProvider.get<MyViewModel>(MyViewModel::class.java)
        myViewModel?.currentSecond?.observe(this) {
            textView?.text = it.toString()
        }
        if (myViewModel?.flag == true) {
            startTimer()
        }
    }

    /**
     * 计时器任务
     */
    private fun startTimer() {
        myViewModel?.flag = false
        Timer().schedule(object : TimerTask() {
            override fun run() {
                var currentSecond = myViewModel?.currentSecond
                //非UI线程用postValue
                //UI线程用setValue
                currentSecond?.postValue(currentSecond.value?.plus(1))

            }

        }, 1000, 1000)
    }
}