package com.ayush0402.newsapp.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel

class TopHeadlinesFragmentViewModel : ViewModel() {
    init {

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "destroyed")
    }
}