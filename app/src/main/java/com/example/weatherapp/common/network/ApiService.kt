package com.example.weatherapp.common.network

import com.example.weatherapp.model.WeatherDetailResponse
import com.example.weatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Lists all the API calls in the application
 */
interface ApiService {
    @GET("weather/list")
    suspend fun getWeatherList(): WeatherResponse?

    @GET("weather/{id}")
    suspend fun getWeatherDetails(@Path("id") weatherId: String): WeatherDetailResponse?
}