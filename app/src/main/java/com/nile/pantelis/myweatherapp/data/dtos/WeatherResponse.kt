package com.nile.pantelis.myweatherapp.data.dtos

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val current_units: CurrentUnits,
    val current: Current,
    val hourly_units: HourlyUnits,
    val hourly: Hourly,
    val daily_units: DailyUnits,
    val daily: Daily
)

