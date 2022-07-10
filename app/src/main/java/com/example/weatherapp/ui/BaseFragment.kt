package com.example.weatherapp.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.weatherapp.ui.viewmodel.BaseViewModel

/**
 * Base fragment class which includes all common functionalities for a fragment.
 */
open class BaseFragment : NavHostFragment() {

    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[BaseViewModel::class.java]
    }

    protected fun showErrorMessage(message: String) {
        viewModel.showMessage(errorMessage = message)
    }
}