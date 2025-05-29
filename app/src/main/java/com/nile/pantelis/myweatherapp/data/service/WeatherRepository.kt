package com.nile.pantelis.myweatherapp.data.service

import android.util.Log
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import org.jetbrains.annotations.Debug

object WeatherRepository: WeatherAPI  {

    private val api: WeatherAPI = RetrofitInstance.getInstance().create(WeatherAPI::class.java)

    override suspend fun getWeatherData(lat: Double, long: Double): WeatherResponse {
        val response = api.getWeatherData(lat, long)

        Log.d("TAG", "Received weather data: $response")
        Log.d("TAG", "")

        return response
    }
}