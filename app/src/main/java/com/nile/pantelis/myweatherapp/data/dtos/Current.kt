package com.nile.pantelis.myweatherapp.data.dtos

data class Current(
    val time: String,
    val interval: Int,
    val temperature_2m: Double,
    val rain: Double,
    val cloud_cover: Int,
    val wind_speed_10m: Double,
    val weather_code: Int,
    val wind_direction_10m: Int,
    val showers: Double,
    val snowfall: Double
)
