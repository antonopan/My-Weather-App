package com.nile.pantelis.myweatherapp.domain.utils

import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import com.nile.pantelis.myweatherapp.domain.helpers.DailyWeatherPresenterData

fun getDailyTemperatures(weatherResponse: WeatherResponse): List<DailyWeatherPresenterData> {
    return weatherResponse.daily.time.mapIndexed { index, date ->
        DailyWeatherPresenterData(
            day = date,
            weatherCode = weatherResponse.daily.weather_code[index],
            temp = Average(
                weatherResponse.daily.temperature_2m_max[index],
                weatherResponse.daily.temperature_2m_min[index]
            )
        )
    }
}

fun Average(temp1: Double, temp2: Double): Double {
    return (temp1 + temp2) /2
}