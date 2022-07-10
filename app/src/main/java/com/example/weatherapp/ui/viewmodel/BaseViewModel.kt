package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.State

/**
 * Base class that contains basic functionalities used in view model.
 */
open class BaseViewModel : ViewModel() {

    fun showLoading(show: Boolean) {
        State.isLoading = show
        State.isError = false
    }

    fun showMessage(isError: Boolean = true, errorMessage: String) {
        State.message = errorMessage
        State.isError = isError
    }
}