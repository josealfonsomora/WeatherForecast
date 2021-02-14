package com.josealfonsomora.weatherforecast.data.model

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.weatherforecast.domain.model.CityWeather

data class CityWeatherDataModel(
    @SerializedName("main") val main: MainDataModel?,
    @SerializedName("weather") val weather: List<WeatherDataModel>?,
    @SerializedName("clouds") val clouds: CloudsDataModel?,
    @SerializedName("wind") val wind: WindDataModel?,
    @SerializedName("visibility") val visibility: Int?,
    @SerializedName("pop") val pop: Float?,
    @SerializedName("sys") val sys: SysDataModel?,
    @SerializedName("dt") val dt: Long?, // 1613304000
    @SerializedName("dt_txt") val dtTxt: String? // 2021-02-14 12:00:00
)

fun CityWeatherDataModel.toDomainModel() = CityWeather(
    dt = this.dt ?: 0,
    main = this.main?.toDomainModel(),
    weather = this.weather?.map { it.toDomainModel() } ?: emptyList(),
    clouds = this.clouds?.toDomainModel(),
    wind = this.wind?.toDomainModel(),
    visibility = this.visibility ?: 0,
    pop = this.pop,
    sys = this.sys?.toDomainModel(),
    dtTxt = this.dtTxt ?: ""
)