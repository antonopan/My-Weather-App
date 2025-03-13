package com.nile.pantelis.myweatherapp.data.dtos

data class Daily(
    val time: List<String>,
    val weather_code: List<Int>,
    val rain_sum: List<Double>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>
)

