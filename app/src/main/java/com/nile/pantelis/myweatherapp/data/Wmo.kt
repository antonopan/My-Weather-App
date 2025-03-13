package com.nile.pantelis.myweatherapp.data

object Wmo {
    val codes = mapOf(
        0 to "Clear sky",
        1 to "Mainly clear",
        2 to "Partly cloudy",
        3 to "Overcast",
        45 to "Fog",
        48 to "Depositing rime fog",
        51 to "Drizzle: Light intensity",
        53 to "Drizzle: Moderate intensity",
        55 to "Drizzle: Dense intensity",
        56 to "Freezing drizzle: Light intensity",
        57 to "Freezing drizzle: Dense intensity",
        61 to "Rain: Slight intensity",
        63 to "Rain: Moderate intensity",
        65 to "Rain: Heavy intensity",
        66 to "Freezing rain: Light intensity",
        67 to "Freezing rain: Heavy intensity",
        71 to "Snowfall: Slight intensity",
        73 to "Snowfall: Moderate intensity",
        75 to "Snowfall: Heavy intensity",
        77 to "Snow grains",
        80 to "Rain showers: Slight intensity",
        81 to "Rain showers: Moderate intensity",
        82 to "Rain showers: Violent intensity",
        85 to "Snow showers: Slight intensity",
        86 to "Snow showers: Heavy intensity",
        95 to "Thunderstorm: Slight or moderate",
        96 to "Thunderstorm with slight hail",
        99 to "Thunderstorm with heavy hail"
    )
}