package com.wj.lifecycle

import androidx.lifecycle.LifecycleService

class MyLocationService : LifecycleService() {

    init {
        var myLocationObserver = MyLocationObserver(this)
        lifecycle.addObserver(myLocationObserver)
    }
}