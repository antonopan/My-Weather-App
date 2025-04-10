package com.nile.pantelis.myweatherapp.domain.utils

fun mergeTemperatureAndUnit(temperature: Double, unit: String): String {
    return temperature.toString() + unit
}