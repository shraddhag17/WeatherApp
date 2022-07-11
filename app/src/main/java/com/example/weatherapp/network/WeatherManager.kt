package com.example.weatherapp.network

import android.util.Log
import com.example.weatherapp.common.network.RetrofitClient
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
}