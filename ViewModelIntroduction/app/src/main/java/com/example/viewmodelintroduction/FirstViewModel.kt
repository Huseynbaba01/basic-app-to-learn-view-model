package com.example.viewmodelintroduction

import android.util.Log
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {
    var message = ""
    var clicks = 0

    override fun onCleared() {
        super.onCleared()
        Log.i("test","View Model Destroyed!")
    }
    init {
        Log.i("test","View Model Created!")
    }
}