package com.josealfonsomora.weatherforecast.data.network

import com.josealfonsomora.weatherforecast.data.model.WeekForecastDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("data/2.5/forecast/")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("units") units: String = "metric"
    ): Response<WeekForecastDataModel>
}

