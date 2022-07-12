package com.example.weatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherActivityBinding
import com.example.weatherapp.model.State

/**
 * Represents Activity for Weather module.
 */
class WeatherActivity : AppCompatActivity() {
    private var binding: WeatherActivityBinding? = null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.state = State
        //Set up navigation component.
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}