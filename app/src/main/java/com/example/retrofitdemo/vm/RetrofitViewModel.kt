package com.example.retrofitdemo.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.Api
import com.example.retrofitdemo.net.RetrofitHelper
import com.mocha.retrofitdemo.entity.WeatherInfo
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class RetrofitViewModel : ViewModel(){

    private val disposables:CompositeDisposable by lazy{
        CompositeDisposable()
    }

    fun addDisposable(d: Disposable){
        disposables.add(d)
    }

    val weatherLiveData = MutableLiveData<WeatherInfo>()


    //http://reactivex.io/documentation/observable.html
    fun getWeather(){
        RetrofitHelper.getRetrofit().create(Api::class.java).getWeather("101010100","sk")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherInfo> {
                override fun onComplete() {}

                override fun onSubscribe(d: Disposable) {
                    addDisposable(d)
                }

                override fun onNext(t: WeatherInfo) {
                    Log.i("https:",t.toString())

                    weatherLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}