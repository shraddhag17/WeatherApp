package com.example.weatherapp.network

import com.example.weatherapp.common.network.RetrofitClient
import com.example.weatherapp.model.WeatherDetailResponse
import com.example.weatherapp.model.WeatherResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Manager class that is responsible for handling domain layer
 * functionalities for Weather module.
 */
object WeatherManager : BaseManager() {

    suspend fun getWeatherList(dispatcher: CoroutineDispatcher = Dispatchers.IO): WeatherResponse? {
        // Move the execution of the coroutine to the I/O dispatcher
        return withContext(dispatcher) {
            // Blocking network request code
            RetrofitClient.client.getWeatherList()
        }
    }

    suspend fun getWeatherDetails(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        weatherId: String?
    ): WeatherDetailResponse? {
        // Move the execution of the coroutine to the I/O dispatcher
        return withContext(dispatcher) {
            // Blocking network request code
            RetrofitClient.client.getWeatherDetails(weatherId ?: "")
        }
    }
}