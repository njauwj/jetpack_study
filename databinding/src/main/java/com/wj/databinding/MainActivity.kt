package com.wj.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wj.databinding.databinding.ActivityMainBinding

/**
 * 记得在gradle配置文件中添加
buildFeatures {
dataBinding = true
}
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.wj = Person("王杰", 23)
    }
}