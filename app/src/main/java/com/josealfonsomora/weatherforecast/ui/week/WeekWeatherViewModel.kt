package com.josealfonsomora.weatherforecast.ui.week

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.weatherforecast.domain.model.CityWeather
import com.josealfonsomora.weatherforecast.domain.model.WeekForecast
import com.josealfonsomora.weatherforecast.repository.WeatherRepository
import com.josealfonsomora.weatherforecast.repository.WeatherRepositoryResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeekWeatherViewModel @ViewModelInject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weekForecast = MutableLiveData<WeekForecast>()
    val weekForecast: LiveData<WeekForecast> = _weekForecast

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = weatherRepository.getWeather("Vigo")) {
                is WeatherRepositoryResult.Success<*> -> {
                    val data = result.data as WeekForecast
                    _weekForecast.postValue(data)
                }
                is WeatherRepositoryResult.Error -> {

                }
            }
        }
    }
}