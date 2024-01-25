package com.wj.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var currentSecond: MutableLiveData<Int> = MutableLiveData()

    var flag: Boolean = true

    init {
        currentSecond.value = 0;
    }


}