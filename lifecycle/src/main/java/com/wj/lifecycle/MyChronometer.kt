package com.wj.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.*

class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs),
    DefaultLifecycleObserver {
    private var elapsedTime: Long = 0L
//    @OnLifecycleEvent 已弃用
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)

    override fun onPause(owner: LifecycleOwner) {
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
        super.onPause(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
        super.onResume(owner)
    }
}