package com.josealfonsomora.weatherforecast.data.network

import com.josealfonsomora.weatherforecast.data.model.WeatherByCityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ForecastApi {
    @GET("data/2.5/weather/")
    suspend fun getWeatherByCity(@Query("q") city: String): Response<WeatherByCityResponse>
}