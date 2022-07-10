package com.example.weatherapp.common.util

import android.content.Context
import android.net.NetworkCapabilities

/**
 * Utility class that contains, connectivity related functionality
 */
object ConnectivityManager {

    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager: android.net.ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager

        return hasInternet(connectivityManager)
    }

    private fun hasInternet(connectivityManager: android.net.ConnectivityManager?): Boolean {
        connectivityManager?.let {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

            return (capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true ||
                    capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true ||
                    capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) == true)
        }

        return false
    }
}