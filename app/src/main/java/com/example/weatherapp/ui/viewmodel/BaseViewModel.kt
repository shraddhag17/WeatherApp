package com.example.weatherapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.weatherapp.model.State

/**
 * Base class that contains basic functionalities used in view model.
 */
open class BaseViewModel(app: Application) : AndroidViewModel(app) {

    fun showLoading(show: Boolean) {
        State.isLoading = show
        State.isError = false
    }

    fun showMessage(isError: Boolean = true, errorMessage: String) {
        State.message = errorMessage
        State.isError = isError
    }
}