package com.mocha.retrofitdemo.entity

data class WeatherInfo(
    var weatherinfo:Info?=null
) {

    data class Info(
        var city:String?,
        var cityid:String?,
        var temp:String?,
        var WD:String?,
        var WS:String?,
        var SD:String?,
        var AP:String?,
        var njd:String?,
        var WSE:String?,
        var time:String?
    )
}