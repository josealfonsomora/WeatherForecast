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
import com.josealfonsomora.weatherforecast.domain.model.WeekForecast
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.DateTime

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

        viewModel.weekForecast.observe(viewLifecycleOwner, Observer { weekForecast: WeekForecast ->
            val groupByDayOfMonth =
                weekForecast.list.groupBy { DateTime(it.dt * 1000).dayOfMonth }.map { it.value }
            binding.weatherList.adapter = WeekForecastListAdapter(groupByDayOfMonth)
        })
    }
}