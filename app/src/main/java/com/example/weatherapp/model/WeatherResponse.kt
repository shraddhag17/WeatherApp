package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents Weather list response.
 */
data class WeatherResponse(
    @SerializedName("list")
    var weathers: List<Weather>
)

data class Weather(
    var name: String?,
    @SerializedName("weather")
    var details: List<Detail>?
)

data class Detail(
    var main: String?,
    var description: String?
)
