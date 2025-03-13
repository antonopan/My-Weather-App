package com.nile.pantelis.myweatherapp.data.dtos

data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val cloud_cover: List<Int>
)
