package com.josealfonsomora.weatherforecast.ui.week

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.weatherforecast.data.model.WeatherByCityResponse
import com.josealfonsomora.weatherforecast.repository.WeatherRepository
import com.josealfonsomora.weatherforecast.repository.WeatherRepositoryResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeekWeatherViewModel @ViewModelInject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weekForecast = MutableLiveData<WeatherByCityResponse>()
    val weekForecast: LiveData<WeatherByCityResponse> = _weekForecast

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = weatherRepository.getWeather("Vigo")) {
                is WeatherRepositoryResult.Success<*> -> {
                    val data = result.data as WeatherByCityResponse
                    _weekForecast.postValue(data)
                }
                is WeatherRepositoryResult.Error -> {

                }
            }
        }
    }
}