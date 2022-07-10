package com.example.weatherapp.common.network

import com.example.weatherapp.model.WeatherResponse
import retrofit2.http.GET

/**
 * Lists all the API calls in the application
 */
interface ApiService {
    @GET("weather/list")
    suspend fun getWeatherList(): WeatherResponse
}