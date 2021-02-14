package com.josealfonsomora.weatherforecast.domain.model

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)