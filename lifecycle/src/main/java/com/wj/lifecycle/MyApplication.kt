package com.wj.lifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        var lifecycle = ProcessLifecycleOwner.get().lifecycle
        lifecycle.addObserver(ApplicationObserver())
    }
}