package com.josealfonsomora.weatherforecast.repository

import com.josealfonsomora.weatherforecast.data.network.ForecastApi
import timber.log.Timber
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: ForecastApi
) {
    suspend fun getWeather(city: String) = try {
        val response = api.getWeatherByCity(city)
        if (response.isSuccessful) {
            WeatherRepositoryResult.Success(response.body())
        } else {
            Timber.e("Error loading weather by city $city. Error response $response")
            Error()
        }
    } catch (t: Throwable) {
        Timber.e(t, "Error loading weather by city $city")
        Error(t)
    }
}

sealed class WeatherRepositoryResult {
    class Success<T>(val data: T) : WeatherRepositoryResult()
    class Error(val throwable: Throwable? = null) : WeatherRepositoryResult()
}
