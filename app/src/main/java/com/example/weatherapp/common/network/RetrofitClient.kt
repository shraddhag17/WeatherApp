package com.example.weatherapp.common.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://testapi.io/api/olestang/"
private const val CONNECTION_TIMEOUT : Long = 10

/**
 * Represents Retrofit client object for application.
 */
object RetrofitClient {
    val client: ApiService by lazy {
        Retrofit.Builder()
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .callTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .build()
            )
            .build()
            .create(ApiService::class.java)
    }
}