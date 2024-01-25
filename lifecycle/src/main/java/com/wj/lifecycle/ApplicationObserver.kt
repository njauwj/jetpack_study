package com.wj.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ApplicationObserver : DefaultLifecycleObserver {


    override fun onCreate(owner: LifecycleOwner) {
        Log.d("wj","onCreate")
        super.onCreate(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("wj","onDestroy")
        super.onDestroy(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("wj","onPause")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("wj","onResume")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("wj","onStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("wj","onStop")
    }
}