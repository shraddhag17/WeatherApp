package com.example.weatherapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.R
import com.example.weatherapp.common.util.ConnectivityManager
import com.example.weatherapp.model.WeatherDetailResponse
import com.example.weatherapp.network.WeatherManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Represents view model for weather detail screen
 */
class WeatherDetailViewModel(var app: Application) : BaseViewModel(app) {
    private var weather: MutableLiveData<WeatherDetailResponse?> = MutableLiveData()
    var weatherDetailLiveData: LiveData<WeatherDetailResponse?> = weather

    fun getWeatherDetails(weatherId: String?) {
        if (ConnectivityManager.isNetworkConnected(app)) {
            viewModelScope.launch {
                fetchWeatherDetails(weatherId)
            }
        } else {
            showMessage(errorMessage = app.getString(R.string.no_internet))
        }
    }

    private suspend fun fetchWeatherDetails(weatherId: String?) {
        try {
            showLoading(true)
            val response = WeatherManager.getWeatherDetails(Dispatchers.IO, weatherId)
            showLoading(false)
            when {
                response != null -> {
                    weather.value = response
                }
                else -> {
                    showMessage(errorMessage = app.getString(R.string.no_data))
                }
            }
        } catch (e: Exception) {
            showLoading(false)
            showMessage(errorMessage = app.getString(R.string.error_occurred))
        }
    }

}