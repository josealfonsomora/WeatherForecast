package com.josealfonsomora.weatherforecast.ui.week

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josealfonsomora.weatherforecast.R
import com.josealfonsomora.weatherforecast.domain.model.CityWeather
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class WeekForecastListAdapter(private val items: List<List<CityWeather>>): RecyclerView.Adapter<WeekForecastListAdapter.ViewHolder>() {
    private var fmt = DateTimeFormat.forPattern("d MMMM, yyyy")

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.week_weather_adapter_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.dayList.adapter = DayForecastListAdapter(item)
        item.firstOrNull()?.dt?.let {
            val date = DateTime(it * 1000).toString(fmt)
            holder.day.text = date
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayList: RecyclerView = view.findViewById(R.id.dayWeatherList)
        val day:TextView = view.findViewById(R.id.day)
    }

}