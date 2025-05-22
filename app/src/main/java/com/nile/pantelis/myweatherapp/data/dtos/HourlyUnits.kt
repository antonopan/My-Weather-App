package com.nile.pantelis.myweatherapp.data.dtos

data class HourlyUnits(
    val time: String,
    val weather_code: String,
    val temperature_2m: String,
    val cloud_cover: String
)
