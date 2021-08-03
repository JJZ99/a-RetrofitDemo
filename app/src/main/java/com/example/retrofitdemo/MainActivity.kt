package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.net.RetrofitHelper
import com.example.retrofitdemo.vm.RetrofitViewModel
import com.example.retrofitdemo.vm.RetrofitViewModelFactory
import kotlinx.android.synthetic.main.activity_main.btnWeather
import kotlinx.android.synthetic.main.activity_main.tvWeather

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProvider(this, RetrofitViewModelFactory()).get(RetrofitViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitHelper.init()
        viewModel.weatherLiveData.observe(this, Observer {
            tvWeather.text = it.toString()
        })

        btnWeather.setOnClickListener {
            viewModel.getWeather()
        }
    }
}