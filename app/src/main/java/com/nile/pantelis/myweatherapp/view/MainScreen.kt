package com.nile.pantelis.myweatherapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nile.pantelis.myweatherapp.data.Demo
import com.nile.pantelis.myweatherapp.data.Wmo
import com.nile.pantelis.myweatherapp.domain.utils.convertToDayName

@Composable
fun MainScreen(
    showCode: Boolean = false
) {
    Column(

    ) {
        Text(
            text = convertToDayName(Demo.weatherResponse.current.time)
        )
        Text(
            text = "Hello"
        )
        Text(
            text = Demo.weatherResponse.current.temperature_2m.toString() +
                    Demo.weatherResponse.current_units.temperature_2m
        )
        if(showCode) {
            Text(
                text = Wmo.codes[Demo.weatherResponse.current.weather_code]!!
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(

) {
    MainScreen(true)
}