package com.josealfonsomora.weatherforecast.data.model

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.weatherforecast.domain.model.City

data class CityDataModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("coord") val coord: CoordDataModel?,
    @SerializedName("country") val country: String?,
    @SerializedName("population") val population: Int?,
    @SerializedName("timezone") val timezone: Int?,
    @SerializedName("sunrise") val sunrise: Int?,
    @SerializedName("sunset") val sunset: Int?
)

fun CityDataModel.toDomainModel() = City(
    id = this.id!!,
    name = this.name ?: "",
    coord = this.coord?.toDomainModel(),
    country = this.country ?: "",
    population = this.population ?: 0,
    timezone = this.timezone,
    sunrise = this.sunrise,
    sunset = this.sunset
)