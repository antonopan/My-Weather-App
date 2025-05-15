package com.nile.pantelis.myweatherapp.domain.utils

import android.util.Log
import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import java.time.LocalDate

fun getTodayTemperatures(weatherResponse: WeatherResponse): List<Pair<String, Double>> {
    val todayDate = LocalDate.now().toString() // e.g., "2025-05-15"

    return weatherResponse.hourly.time
        .mapIndexed { index, time ->
            Pair(time, weatherResponse.hourly.temperature_2m[index])
        }
        .filter { (time, _) ->
            time.startsWith(todayDate) // Keep only today's values
        }
}