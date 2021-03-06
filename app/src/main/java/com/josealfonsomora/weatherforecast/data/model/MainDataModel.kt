package com.josealfonsomora.weatherforecast.data.model

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.weatherforecast.domain.model.WeatherMain

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class MainDataModel(
	@SerializedName("temp") val temp: Double, // 289.84
	@SerializedName("temp_kf") val tempKf: Double, // 0.58
	@SerializedName("feels_like") val feelsLike: Double,
	@SerializedName("temp_min") val tempMin: Double,
	@SerializedName("temp_max") val tempMax: Double,
	@SerializedName("pressure") val pressure: Int,
	@SerializedName("humidity") val humidity: Int,
	@SerializedName("sea_level") val seaLevel: Int,
	@SerializedName("grnd_level") val grndLevel: Int,
)

fun MainDataModel.toDomainModel() = WeatherMain(
	temp = this.temp,
	tempKf = this.tempKf,
	feelsLike = this.feelsLike,
	tempMin = this.tempMin,
	tempMax = this.tempMax,
	pressure = this.pressure,
	humidity = this.humidity,
	seaLevel = this.seaLevel,
	grndLevel = this.grndLevel
)