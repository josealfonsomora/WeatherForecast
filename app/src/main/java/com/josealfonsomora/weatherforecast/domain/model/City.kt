package com.josealfonsomora.weatherforecast.domain.model

data class City(
    val id: Int,
    val coord: Coord?,
    val name: String,
    val country: String,
    val population: Int,
    val timezone: Int?,
    val sunrise: Int?,
    val sunset: Int?
)