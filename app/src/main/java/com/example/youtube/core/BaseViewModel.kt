package com.example.youtube.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(){
    var errorMessege = MutableLiveData<String>()
}