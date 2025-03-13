package com.nile.pantelis.myweatherapp.data.dtos

data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val rain: String,
    val cloud_cover: String,
    val wind_speed_10m: String,
    val weather_code: String,
    val wind_direction_10m: String,
    val showers: String,
    val snowfall: String
)

