package com.example.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.WeatherDetailFragmentBinding
import com.example.weatherapp.ui.viewmodel.WeatherDetailViewModel

private const val EXTRA_WEATHER_ID = "weatherId"

class WeatherDetailFragment : Fragment() {

    var binding: WeatherDetailFragmentBinding? = null
    private var viewModel: WeatherDetailViewModel? = null
    private var weatherId: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WeatherDetailFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[WeatherDetailViewModel::class.java]
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        arguments?.let {
            weatherId = it.getString(EXTRA_WEATHER_ID).toString()
        }
        viewModel?.getWeatherDetails(weatherId)
    }

    private fun initObserver() {
        viewModel?.weatherDetailLiveData?.observe(viewLifecycleOwner) { response ->
            binding?.response = response
            binding?.executePendingBindings()
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}