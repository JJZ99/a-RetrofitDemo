package com.example.retrofitdemo.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RetrofitViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RetrofitViewModel::class.java)) {
            return RetrofitViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}