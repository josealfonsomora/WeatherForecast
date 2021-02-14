package com.josealfonsomora.weatherforecast.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.josealfonsomora.weatherforecast.CoroutinesTestRule
import com.josealfonsomora.weatherforecast.data.model.WeekForecastDataModel
import com.josealfonsomora.weatherforecast.data.network.ForecastApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import retrofit2.Response

@ExperimentalCoroutinesApi
class WeatherRepositoryTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val ctr = CoroutinesTestRule()

    private val weekForecastDataModel: WeekForecastDataModel = mockk(relaxed = true)

    private val api: ForecastApi = mockk(relaxed = true) {
        coEvery { getWeatherByCity(any()) }.returns(Response.success(weekForecastDataModel))
    }

    private val repository = WeatherRepository(api)

    @Test
    fun `getWeather with any city returns week forectas from api`() =
        ctr.dispatcher.runBlockingTest {
            val result = repository.getWeather("Dublin")

            assertTrue(result is WeatherRepositoryResult.Success<*>)
        }
}