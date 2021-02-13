package com.josealfonsomora.weatherforecast.ui.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.josealfonsomora.weatherforecast.R
import com.josealfonsomora.weatherforecast.databinding.FragmentWeekWeatherBinding
import com.josealfonsomora.weatherforecast.domain.CityWeather
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WeekWeatherFragment : Fragment(R.layout.fragment_week_weather) {

    lateinit var binding: FragmentWeekWeatherBinding

    private val viewModel: WeekWeatherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weekForecast.observe(viewLifecycleOwner, Observer { cityWeather: CityWeather ->
            cityWeather.weather.forEach { weather ->
                Timber.d("Weather $weather")
            }
        })
    }
}