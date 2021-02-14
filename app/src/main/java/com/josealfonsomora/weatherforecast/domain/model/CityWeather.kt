package com.josealfonsomora.weatherforecast.domain.model

data class CityWeather(
    val weather: List<Weather>,
    val main: WeatherMain?,
    val visibility: Int,
    val wind: Wind?,
    val clouds: Clouds?,
    val dt: Long,
    val pop: Float?,
    val sys: Sys?,
    val dtTxt:String
)