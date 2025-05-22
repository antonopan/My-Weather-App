package com.nile.pantelis.myweatherapp.data

import com.nile.pantelis.myweatherapp.data.dtos.Current
import com.nile.pantelis.myweatherapp.data.dtos.CurrentUnits
import com.nile.pantelis.myweatherapp.data.dtos.Daily
import com.nile.pantelis.myweatherapp.data.dtos.DailyUnits
import com.nile.pantelis.myweatherapp.data.dtos.Hourly
import com.nile.pantelis.myweatherapp.data.dtos.HourlyUnits
import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse

object Demo {
    val weatherResponse = WeatherResponse(
        latitude = 35.3125,
        longitude = 25.125,
        generationtime_ms = 0.09262561798095703,
        utc_offset_seconds = 7200,
        timezone = "Europe/Athens",
        timezone_abbreviation = "GMT+2",
        elevation = 65.0,
        current_units = CurrentUnits(
            time = "iso8601",
            interval = "seconds",
            temperature_2m = "°C",
            rain = "mm",
            cloud_cover = "%",
            wind_speed_10m = "km/h",
            weather_code = "wmo code",
            wind_direction_10m = "°",
            showers = "mm",
            snowfall = "cm"
        ),
        current = Current(
            time = "2025-03-13T16:45",
            interval = 900,
            temperature_2m = 22.9,
            rain = 0.00,
            cloud_cover = 0,
            wind_speed_10m = 36.8,
            weather_code = 0,
            wind_direction_10m = 176,
            showers = 0.00,
            snowfall = 0.00
        ),
        hourly_units = HourlyUnits(
            time = "iso8601",
            weather_code = "Yolanda",
            temperature_2m = "°C",
            cloud_cover = "%"
        ),
        hourly = Hourly(
            time = listOf(
                "2025-03-13T00:00", "2025-03-13T01:00", "2025-03-13T02:00", "2025-03-13T03:00", "2025-03-13T04:00",
                "2025-03-13T05:00", "2025-03-13T06:00", "2025-03-13T07:00", "2025-03-13T08:00", "2025-03-13T09:00"
            ),
            weather_code = listOf(3, 2, 0, 3, 3, 80, 80, 7 ,9),
            temperature_2m = listOf(
                18.8, 18.7, 18.7, 18.3, 17.8, 17.8, 18.0, 18.2, 18.7, 19.3
            ),
            cloud_cover = listOf(
                78, 79, 98, 97, 100, 100, 100, 100, 100, 97
            )
        ),
        daily_units = DailyUnits(
            time = "iso8601",
            weather_code = "wmo code",
            rain_sum = "mm",
            temperature_2m_max = "°C",
            temperature_2m_min = "°C"
        ),
        daily = Daily(
            time = listOf("2025-03-13", "2025-03-14", "2025-03-15", "2025-03-16", "2025-03-17", "2025-03-18", "2025-03-19"),
            weather_code = listOf(3, 2, 0, 3, 3, 80, 80),
            rain_sum = listOf(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 3.90),
            temperature_2m_max = listOf(24.3, 23.5, 29.0, 29.2, 22.6, 17.6, 10.6),
            temperature_2m_min = listOf(17.8, 14.5, 16.5, 16.8, 13.4, 11.1, 8.0)
        )
    )

}