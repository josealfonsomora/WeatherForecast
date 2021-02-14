package com.josealfonsomora.weatherforecast.domain.model

data class WeekForecast(
    val cod: Int,
    val message: Int,
    val cnt: Int,
    val list: List<CityWeather>,
    val city: City
)
