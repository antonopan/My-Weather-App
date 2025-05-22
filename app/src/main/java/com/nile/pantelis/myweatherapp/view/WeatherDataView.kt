package com.nile.pantelis.myweatherapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nile.pantelis.myweatherapp.R
import com.nile.pantelis.myweatherapp.data.Demo
import com.nile.pantelis.myweatherapp.data.Wmo
import com.nile.pantelis.myweatherapp.data.WmoInfo
import com.nile.pantelis.myweatherapp.domain.helpers.WeatherDataViewMode
import com.nile.pantelis.myweatherapp.domain.utils.convertDateToDayName
import com.nile.pantelis.myweatherapp.domain.utils.convertToDayName

@Composable
fun WeatherDataView(
    modifier: Modifier = Modifier,
    showCode: WeatherDataViewMode = WeatherDataViewMode.MainTemp,
    currentTime: String = Demo.weatherResponse.current.time,
    weatherIcon: WmoInfo? = Wmo.codes[Demo.weatherResponse.current.weather_code],
    temperature: String = Demo.weatherResponse.current.temperature_2m.toString() + Demo.weatherResponse.current_units.temperature_2m,
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (showCode == WeatherDataViewMode.MainTemp) {
                convertToDayName(currentTime)
            } else if (showCode == WeatherDataViewMode.HourlyTemp) {
                currentTime.takeLast(5)
            } else {
                convertDateToDayName(currentTime) //.takeLast(5)
            }
        )
        Icon(
            painter = painterResource(
                weatherIcon?.icon
                    ?: R.drawable.cloud_alert_24dp
            ),
            contentDescription = weatherIcon?.title
                ?: "No retrieved data",
            tint = Color.White,
            modifier = Modifier.size(
                if (showCode == WeatherDataViewMode.MainTemp) {
                    72.dp
                } else {
                    22.dp
                }
            )

        )
        Text(
            text = temperature,
            fontSize = if (showCode == WeatherDataViewMode.MainTemp) {
                29.sp
            } else {
                15.sp
            }
        )
        if (showCode == WeatherDataViewMode.MainTemp) {
            Text(
                text = weatherIcon?.title
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
        showCode = WeatherDataViewMode.MainTemp
    )
}

