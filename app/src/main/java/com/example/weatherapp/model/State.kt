package com.example.weatherapp.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Represents common UI states to be handled.
 */
object State : BaseObservable() {
    //True if Loading, False otherwise
    @get:Bindable
    var isLoading: Boolean = false
        set(value) {
            field = value
            notifyChange()
        }

    //True if Error, False otherwise
    @get:Bindable
    var isError: Boolean = false
        set(value) {
            field = value
            notifyChange()
        }

    //Shows text message to the user.
    @get:Bindable
    var message: String = "No data"
        set(value) {
            field = value
            notifyChange()
        }
}