package com.nile.pantelis.myweatherapp.data

object Endpoints {
    val METEO_DAILY_FORECAST_ENDPOINT = "https://api.open-meteo.com/v1/forecast?latitude=35.3279&longitude=25.1434&daily=weather_code,rain_sum&hourly=temperature_2m,cloud_cover&current=temperature_2m,rain,cloud_cover,wind_speed_10m,weather_code,wind_direction_10m,showers,snowfall&timezone=auto"
}