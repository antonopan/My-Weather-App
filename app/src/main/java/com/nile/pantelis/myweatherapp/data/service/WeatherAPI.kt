package com.nile.pantelis.myweatherapp.data.service

import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import com.nile.pantelis.myweatherapp.data.service.Endpoints.METEO_DAILY_FORECAST_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET(METEO_DAILY_FORECAST_ENDPOINT)
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherResponse
}