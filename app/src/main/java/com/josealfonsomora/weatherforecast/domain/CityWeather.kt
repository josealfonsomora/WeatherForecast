package com.josealfonsomora.weatherforecast.domain

data class CityWeather(
    val id: Int,
    val coord: Coord?,
    val weather: List<Weather>,
    val base: String,
    val main: WeatherMain?,
    val visibility: Int,
    val wind: Wind?,
    val clouds: Clouds?,
    val dt: Int,
    val sys: Sys?,
    val timezone: Int?,
    val name: String,
    val cod: Int
)