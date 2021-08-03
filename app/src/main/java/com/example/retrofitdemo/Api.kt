package com.example.retrofitdemo

import com.mocha.retrofitdemo.entity.WeatherInfo
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("http://www.weather.com.cn/data/sk/{cityCode}.html")
    fun getWeather(@Path("cityCode") code: String): Observable<WeatherInfo>

   /* @GET("https://api.weibo.com/oauth2/authorize?client_id=3595354204&redirect_uri=https://api.weibo.com/oauth2/{cityCode}.html")
    fun getWeather(@Path("cityCode") code: String): Observable<String>*/

}