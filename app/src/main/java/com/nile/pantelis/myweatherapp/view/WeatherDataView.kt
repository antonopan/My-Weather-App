package com.nile.pantelis.myweatherapp.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nile.pantelis.myweatherapp.R
import com.nile.pantelis.myweatherapp.data.Demo
import com.nile.pantelis.myweatherapp.data.Wmo
import com.nile.pantelis.myweatherapp.domain.utils.convertToDayName

@Composable
fun WeatherDataView(
    modifier: Modifier = Modifier,
    showCode: Boolean = false
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (showCode) {
                convertToDayName(Demo.weatherResponse.current.time)
            } else {
                convertToDayName(Demo.weatherResponse.current.time).take(3)
            }
        )
        Icon(
            painter = painterResource(Wmo.codes[Demo.weatherResponse.current.weather_code]?.icon
                ?: R.drawable.cloud_alert_24dp),
            contentDescription = Wmo.codes[Demo.weatherResponse.current.weather_code]?.title
                ?: "No retrieved data",
            modifier = Modifier.size(if (showCode) {
                72.dp
            } else {
                22.dp
            })

        )
        Text(
            text = Demo.weatherResponse.current.temperature_2m.toString() +
                    Demo.weatherResponse.current_units.temperature_2m,
            fontSize = if (showCode) {
                29.sp
            } else {
                15.sp
            }
        )
        if(showCode) {
            Text(
                text = Wmo.codes[Demo.weatherResponse.current.weather_code]?.title
                    ?: "No retrieved data"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherDataViewPreview(

) {
    WeatherDataView(
        showCode = true
    )
}

