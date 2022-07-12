package com.example.weatherapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.R
import com.example.weatherapp.common.util.ConnectivityManager
import com.example.weatherapp.model.Weather
import com.example.weatherapp.network.WeatherManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Represents view model for weather list screen.
 */
class WeatherViewModel(var app: Application) : BaseViewModel(app) {

    private var weather: MutableLiveData<List<Weather>?> = MutableLiveData()
    var weatherLiveData: LiveData<List<Weather>?> = weather

    fun getWeatherList() {
        if (ConnectivityManager.isNetworkConnected(app)) {
            viewModelScope.launch {
                fetchWeatherList()
            }
        } else {
            showMessage(errorMessage = app.getString(R.string.no_internet))
        }
    }

    private suspend fun fetchWeatherList() {
        try {
            showLoading(true)
            val response = WeatherManager.getWeatherList(Dispatchers.IO)
            showLoading(false)
            when {
                response?.isValidResponse() == true -> {
                    weather.value = response.weathers
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