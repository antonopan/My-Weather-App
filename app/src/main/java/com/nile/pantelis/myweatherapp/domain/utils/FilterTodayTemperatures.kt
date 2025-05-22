package com.nile.pantelis.myweatherapp.domain.utils

import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import com.nile.pantelis.myweatherapp.domain.helpers.DailyWeatherPresenterData
import java.time.LocalDate

fun getTodayTemperatures(weatherResponse: WeatherResponse): List<DailyWeatherPresenterData> {
    val todayDate = LocalDate.now().toString()
    val result = mutableListOf<DailyWeatherPresenterData>()

    for (i in weatherResponse.hourly.time.indices) {
        val time = weatherResponse.hourly.time[i]
        if (time.startsWith(todayDate)) {

            val hourlyWeather = DailyWeatherPresenterData(
                day = time,
                weatherCode = weatherResponse.hourly.weather_code[i],
                temp = weatherResponse.hourly.temperature_2m[i]
            )
            result.add(hourlyWeather)
        } else if (time > todayDate) {
            // Since the list is sorted, no more today's values beyond this point
            break
        }
    }

    return result
}