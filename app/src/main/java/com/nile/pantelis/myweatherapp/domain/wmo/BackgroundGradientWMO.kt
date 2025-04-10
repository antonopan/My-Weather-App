package com.nile.pantelis.myweatherapp.domain.wmo

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import com.nile.pantelis.myweatherapp.R
import com.nile.pantelis.myweatherapp.data.WmoInfo
import com.nile.pantelis.myweatherapp.ui.theme.ClearDay2
import com.nile.pantelis.myweatherapp.ui.theme.Cloudy
import com.nile.pantelis.myweatherapp.ui.theme.Rainy
import com.nile.pantelis.myweatherapp.ui.theme.Snow
import com.nile.pantelis.myweatherapp.ui.theme.Storm

object BackgroundGradientWMO {
    val backgroundColor = mapOf(
        0 to setBackgroundGradient(ClearDay2),
        1 to setBackgroundGradient(ClearDay2), // clear day, bedtime
        2 to setBackgroundGradient(ClearDay2), // partly cloudy day, nights stay
        3 to setBackgroundGradient(Cloudy), // partly cloudy day, nights stay
        45 to setBackgroundGradient(Cloudy), // foggy
        48 to setBackgroundGradient(Cloudy), // foggy
        51 to setBackgroundGradient(Rainy), // rainy
        53 to setBackgroundGradient(Rainy), // rainy
        55 to setBackgroundGradient(Rainy), // rainy
        56 to setBackgroundGradient(Rainy), // weather mix
        57 to setBackgroundGradient(Rainy), //weather mix
        61 to setBackgroundGradient(Rainy), // rainy
        63 to setBackgroundGradient(Rainy), // rainy
        65 to setBackgroundGradient(Rainy), // rainy
        66 to setBackgroundGradient(Snow), // weather hail
        67 to setBackgroundGradient(Snow), // weather hail
        71 to setBackgroundGradient(Snow), // weather snowy
        73 to setBackgroundGradient(Snow), // weather snowy
        75 to setBackgroundGradient(Snow), // weather snowy
        77 to setBackgroundGradient(Snow), // weather snowy
        80 to setBackgroundGradient(Rainy), // rainy
        81 to setBackgroundGradient(Rainy), // rainy
        82 to setBackgroundGradient(Rainy), // rainy
        85 to setBackgroundGradient(Snow), // weather snowy
        86 to setBackgroundGradient(Snow), // weather snowy
        95 to setBackgroundGradient(Storm), // thunderstorm
        96 to setBackgroundGradient(Storm), // thunderstorm
        99 to setBackgroundGradient(Storm) // thunderstorm
    )

    private fun setBackgroundGradient(color: Color): Brush {

        val gradient1 = adjustColorLightnessBy(color, -20f)

        return Brush.verticalGradient(listOf(gradient1, color))
    }

    private fun adjustColorLightnessBy(color: Color, delta: Float): Color {
        val hsl = FloatArray(3)
        ColorUtils.colorToHSL(color.toArgb(), hsl)

        // Current lightness in 0–100 scale
        val currentLightness = hsl[2] * 100f

        // Apply delta (positive = lighter, negative = darker)
        val newLightness = (currentLightness + delta).coerceIn(0f, 100f)
        hsl[2] = newLightness / 100f

        return Color(ColorUtils.HSLToColor(hsl))
    }
}