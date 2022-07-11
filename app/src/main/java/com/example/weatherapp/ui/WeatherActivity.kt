package com.example.weatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.WeatherActivityBinding
import com.example.weatherapp.model.State

/**
 * Represents Activity for Weather module.
 */
class WeatherActivity : AppCompatActivity() {
    private var binding: WeatherActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.state = State
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}