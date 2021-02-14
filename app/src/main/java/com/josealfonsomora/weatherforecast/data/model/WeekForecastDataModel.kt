package com.josealfonsomora.weatherforecast.data.model

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.weatherforecast.domain.model.WeekForecast

data class WeekForecastDataModel(
    @SerializedName("cod") val cod: Int,
    @SerializedName("message") val message: Int,
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val list: List<CityWeatherDataModel>,
    @SerializedName("city") val city: CityDataModel
)

fun WeekForecastDataModel.toDomainModel() = WeekForecast(
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    list = this.list.map { it.toDomainModel() },
    city = this.city.toDomainModel()
)