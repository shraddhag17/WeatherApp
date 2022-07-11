package com.example.weatherapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.WeatherItemBinding
import com.example.weatherapp.model.Weather
import com.example.weatherapp.ui.viewmodel.WeatherItemViewModel

/**
 * This class is responsible to bind data to the UI - List of Items
 */
class WeatherAdapter(
    private var context: Context,
    var items: List<Weather>
) : RecyclerView.Adapter<WeatherAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ItemVH {

        return ItemVH(WeatherItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ItemVH, position: Int) {
        holder.bindItem(
            WeatherItemViewModel(items[position]),
            object : WeatherItemViewModel.OnItemClickListener {
                override fun onItemClicked(weather: Weather) {
                    //Handle click
                }
            })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemVH(var binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(vm: WeatherItemViewModel, listener: WeatherItemViewModel.OnItemClickListener) {
            binding.data = vm.weather
            binding.listener = listener
            binding.executePendingBindings()
        }
    }
}