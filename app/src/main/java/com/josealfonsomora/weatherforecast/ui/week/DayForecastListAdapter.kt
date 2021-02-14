package com.josealfonsomora.weatherforecast.ui.week

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.josealfonsomora.weatherforecast.R
import com.josealfonsomora.weatherforecast.domain.model.CityWeather
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class DayForecastListAdapter(private val items: List<CityWeather>) :
    RecyclerView.Adapter<DayForecastListAdapter.ViewHolder>() {
    private var fmt = DateTimeFormat.forPattern("hh:mm a")

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_adapter_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        item.weather.firstOrNull()?.let {
            val resources = holder.weatherIcon.context.resources
            // Weather conditions to show
            // https://openweathermap.org/weather-conditions
            ResourcesCompat.getDrawable(
                resources, when (it.id) {
                    in (200..299) -> R.drawable.ic_baseline_cloud_24 // Thunderstorm
                    in (300..399) -> R.drawable.ic_baseline_cloud_24 // Drizzle
                    in (500..599) -> R.drawable.ic_baseline_cloud_24 // Rain
                    in (600..699) -> R.drawable.ic_baseline_snow_24 // Snow
                    800 -> R.drawable.ic_baseline_wb_sunny_24 // Clear
                    else -> R.drawable.ic_baseline_snow_24
                }, null
            )
        }
        val time = DateTime(item.dt * 1000).toString(fmt)
        holder.time.text = time
        item.weather.firstOrNull()?.let {
            holder.description.text = "${it.main}, ${it.description}"
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weatherIcon: ImageView = view.findViewById(R.id.weatherIcon)
        val time: TextView = view.findViewById(R.id.time)
        val description: TextView = view.findViewById(R.id.description)
    }

}