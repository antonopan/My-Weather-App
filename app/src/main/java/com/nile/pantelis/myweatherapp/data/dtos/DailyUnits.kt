package com.nile.pantelis.myweatherapp.data.dtos

data class DailyUnits(
    val time: String,
    val weather_code: String,
    val rain_sum: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String
)
