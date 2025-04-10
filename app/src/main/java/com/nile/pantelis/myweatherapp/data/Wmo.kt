package com.nile.pantelis.myweatherapp.data

import com.nile.pantelis.myweatherapp.R

object Wmo {
    val codes = mapOf(
        0 to WmoInfo("Clear sky", R.drawable.clear_day_24dp),
        1 to WmoInfo("Mainly clear", R.drawable.clear_day_24dp), // clear day, bedtime
        2 to WmoInfo("Partly cloudy", R.drawable.partly_cloudy_day_24dp), // partly cloudy day, nights stay
        3 to WmoInfo("Overcast", R.drawable.cloud_24dp), // partly cloudy day, nights stay
        45 to WmoInfo("Fog", R.drawable.foggy_24dp), // foggy
        48 to WmoInfo("Depositing rime fog", R.drawable.foggy_24dp), // foggy
        51 to WmoInfo("Drizzle: Light intensity", R.drawable.rainy_24dp), // rainy
        53 to WmoInfo("Drizzle: Moderate intensity", R.drawable.rainy_24dp), // rainy
        55 to WmoInfo("Drizzle: Dense intensity", R.drawable.rainy_24dp), // rainy
        56 to WmoInfo("Freezing drizzle: Light intensity", R.drawable.weather_mix_24dp), // weather mix
        57 to WmoInfo("Freezing drizzle: Dense intensity", R.drawable.weather_mix_24dp), //weather mix
        61 to WmoInfo("Rain: Slight intensity", R.drawable.rainy_24dp), // rainy
        63 to WmoInfo("Rain: Moderate intensity", R.drawable.rainy_24dp), // rainy
        65 to WmoInfo("Rain: Heavy intensity", R.drawable.rainy_24dp), // rainy
        66 to WmoInfo("Freezing rain: Light intensity", R.drawable.weather_hail_24dp), // weather hail
        67 to WmoInfo("Freezing rain: Heavy intensity", R.drawable.weather_hail_24dp), // weather hail
        71 to WmoInfo("Snowfall: Slight intensity", R.drawable.weather_snowy_24dp), // weather snowy
        73 to WmoInfo("Snowfall: Moderate intensity", R.drawable.weather_snowy_24dp), // weather snowy
        75 to WmoInfo("Snowfall: Heavy intensity", R.drawable.weather_snowy_24dp), // weather snowy
        77 to WmoInfo("Snow grains", R.drawable.weather_snowy_24dp), // weather snowy
        80 to WmoInfo("Rain showers: Slight intensity", R.drawable.rainy_24dp), // rainy
        81 to WmoInfo("Rain showers: Moderate intensity", R.drawable.rainy_24dp), // rainy
        82 to WmoInfo("Rain showers: Violent intensity", R.drawable.rainy_24dp), // rainy
        85 to WmoInfo("Snow showers: Slight intensity", R.drawable.weather_snowy_24dp), // weather snowy
        86 to WmoInfo("Snow showers: Heavy intensity", R.drawable.weather_snowy_24dp), // weather snowy
        95 to WmoInfo("Thunderstorm: Slight or moderate", R.drawable.thunderstorm_24dp), // thunderstorm
        96 to WmoInfo("Thunderstorm with slight hail", R.drawable.thunderstorm_24dp), // thunderstorm
        99 to WmoInfo("Thunderstorm with heavy hail", R.drawable.thunderstorm_24dp) // thunderstorm
    )


//    val codes = mapOf(
//        0 to WmoInfo("Clear sky"), // clear day, bedtime
//        1 to "Mainly clear", // clear day, bedtime
//        2 to "Partly cloudy", // partly cloudy day, nights stay
//        3 to "Overcast", // partly cloudy day, nights stay
//        45 to "Fog", // foggy
//        48 to "Depositing rime fog", // foggy
//        51 to "Drizzle: Light intensity", // rainy
//        53 to "Drizzle: Moderate intensity", // rainy
//        55 to "Drizzle: Dense intensity", // rainy
//        56 to "Freezing drizzle: Light intensity", // weather mix
//        57 to "Freezing drizzle: Dense intensity", //weather mix
//        61 to "Rain: Slight intensity", // rainy
//        63 to "Rain: Moderate intensity", // rainy
//        65 to "Rain: Heavy intensity", // rainy
//        66 to "Freezing rain: Light intensity", // weather hail
//        67 to "Freezing rain: Heavy intensity", // weather hail
//        71 to "Snowfall: Slight intensity", // weather snowy
//        73 to "Snowfall: Moderate intensity", // weather snowy
//        75 to "Snowfall: Heavy intensity", // weather snowy
//        77 to "Snow grains", // weather snowy
//        80 to "Rain showers: Slight intensity", // rainy
//        81 to "Rain showers: Moderate intensity", // rainy
//        82 to "Rain showers: Violent intensity", // rainy
//        85 to "Snow showers: Slight intensity", // weather snowy
//        86 to "Snow showers: Heavy intensity", // weather snowy
//        95 to "Thunderstorm: Slight or moderate", // thunderstorm
//        96 to "Thunderstorm with slight hail", // thunderstorm
//        99 to "Thunderstorm with heavy hail" // thunderstorm
//    )
}

