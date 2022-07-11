package com.example.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.ui.adapter.WeatherAdapter
import com.example.weatherapp.ui.viewmodel.WeatherViewModel

/**
 * Represents weather list screen
 */
class WeatherFragment : BaseFragment() {

    var binding: WeatherFragmentBinding? = null
    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WeatherFragmentBinding.inflate(layoutInflater)

        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        weatherViewModel.getWeatherList()
    }

    private fun initObserver() {
        weatherViewModel.weatherLiveData.observe(viewLifecycleOwner) { items ->
            items?.let {
                if (binding?.recyclerView?.adapter == null) {
                    binding?.recyclerView?.adapter =
                        WeatherAdapter(requireContext(), items)
                }
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}