package com.josealfonsomora.weatherforecast.domain.model

data class WeatherMain(
    val temp: Double,
    val tempKf: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    val seaLevel:Int,
    val grndLevel:Int
)