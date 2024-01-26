package com.wj.livedata2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var process: MutableLiveData<Int> = MutableLiveData(0)

}