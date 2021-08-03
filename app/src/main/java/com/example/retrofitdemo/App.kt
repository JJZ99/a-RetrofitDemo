package com.example.retrofitdemo

import android.app.Application
import com.example.retrofitdemo.net.RetrofitHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        //RetrofitHelper.init()
    }
}