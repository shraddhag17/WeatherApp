package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents Weather list response.
 */
data class WeatherResponse(
    @SerializedName("list")
    var weathers: List<Weather>
) {
    fun isValidResponse(): Boolean {
        return weathers.isNotEmpty()
    }
}

data class Weather(
    var id: String?,
    var name: String?,
    @SerializedName("weather")
    var details: List<Detail>?
)

data class Detail(
    @SerializedName("main")
    var title: String?,
    @SerializedName("description")
    var description: String?
)
