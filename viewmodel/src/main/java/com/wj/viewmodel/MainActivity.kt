package com.wj.viewmodel

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity() {


    /**
     * 屏幕每次旋转onCreate就会执行一次
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("wj", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView = findViewById<TextView>(R.id.textView)
        var button = findViewById<Button>(R.id.button)
        var viewModelProvider =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
        var myViewModel = viewModelProvider.get<MyViewModel>(MyViewModel::class.java)
        textView.text = (myViewModel.number).toString()
        button.setOnClickListener {
            textView.text = ((++myViewModel.number).toString())
        }
    }
}