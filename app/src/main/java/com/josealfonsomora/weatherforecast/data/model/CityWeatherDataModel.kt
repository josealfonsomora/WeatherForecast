package com.josealfonsomora.weatherforecast.data.model

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.weatherforecast.domain.CityWeather

data class CityWeatherDataModel(
    @SerializedName("coord") val coord: CoordDataModel?,
    @SerializedName("weather") val weather: List<WeatherDataModel>?,
    @SerializedName("base") val base: String?,
    @SerializedName("main") val main: MainDataModel?,
    @SerializedName("visibility") val visibility: Int?,
    @SerializedName("wind") val wind: WindDataModel?,
    @SerializedName("clouds") val clouds: CloudsDataModel?,
    @SerializedName("dt") val dt: Int?,
    @SerializedName("sys") val sys: SysDataModel?,
    @SerializedName("timezone") val timezone: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("cod") val cod: Int?
)

fun CityWeatherDataModel.toDomainModel() = CityWeather(
    id = this.id!!,
    coord = this.coord?.toDomainModel(),
    weather = this.weather?.map { it.toDomainModel() } ?: emptyList(),
    base = this.base ?: "",
    main = this.main?.toDomainModel(),
    visibility = this.visibility ?: 0,
    wind = this.wind?.toDomainModel(),
    clouds = this.clouds?.toDomainModel(),
    dt = this.dt ?: 0,
    sys = this.sys?.toDomainModel(),
    timezone = this.timezone,
    name = this.name ?: "",
    cod = this.cod ?: 0
)