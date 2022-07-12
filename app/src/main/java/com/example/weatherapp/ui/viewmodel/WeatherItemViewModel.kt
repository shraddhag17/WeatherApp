package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.Weather

/**
 * Represents view model for weather item.
 */
class WeatherItemViewModel(var weather: Weather?) : ViewModel() {
    interface OnItemClickListener {
        fun onItemClicked(weather: Weather)
    }
}