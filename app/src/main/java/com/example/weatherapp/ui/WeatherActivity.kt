package com.example.weatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.WeatherActivityBinding
import com.example.weatherapp.model.State

/**
 * Represents Activity for Weather module.
 */
class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDataVariables(binding)
    }

    private fun initDataVariables(binding: WeatherActivityBinding) {
        binding.isLoading = State.isLoading
        binding.isError = State.isError
        binding.message = State.message
    }

}