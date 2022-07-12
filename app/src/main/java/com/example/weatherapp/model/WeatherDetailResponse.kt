package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents weather details.
 */
data class WeatherDetailResponse(
    var id: String?,

    var name: String?,
    @SerializedName("coord")
    var coordinates: Coordinates,
    @SerializedName("main")
    var temp: Temperature,
    var wind: Wind
)

data class Coordinates(
    var lon: String?,
    var lat: String?
)

data class Temperature(
    var temp: String?,
    @SerializedName("temp_min")
    var tempMin: String?,
    @SerializedName("temp_max")
    var tempMax: String?,
    var humidity: String?,
)

data class Wind(var speed: String?)
