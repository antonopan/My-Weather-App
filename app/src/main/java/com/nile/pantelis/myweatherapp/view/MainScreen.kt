package com.nile.pantelis.myweatherapp.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nile.pantelis.myweatherapp.R
import com.nile.pantelis.myweatherapp.data.Demo
import com.nile.pantelis.myweatherapp.data.Wmo
import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import com.nile.pantelis.myweatherapp.data.service.WeatherRepository
import com.nile.pantelis.myweatherapp.domain.utils.getTodayTemperatures
import com.nile.pantelis.myweatherapp.domain.utils.mergeTemperatureAndUnit
import com.nile.pantelis.myweatherapp.domain.wmo.BackgroundGradientWMO

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    val background =
        BackgroundGradientWMO.backgroundColor[Demo.weatherResponse.current.weather_code]
            ?: Brush.sweepGradient(listOf(Color.LightGray, Color.Gray))

    var weather by remember { mutableStateOf<WeatherResponse?>(null) }

    LaunchedEffect(key1 = Unit) {
        // This runs once when the composable enters the composition
//        latitude=35.3279&longitude=25.1434&
        weather = WeatherRepository.getWeatherData(35.3279, 25.1434)
    }

    if (weather != null) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Heraklion"
            )

            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly, // Evenly space remaining items
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherDataView(
                    modifier = Modifier.fillMaxWidth(),
//                    .background(Color.Gray)
                    currentTime = weather!!.current.time,
                    weatherIcon = Wmo.codes[weather!!.current.weather_code],
                    temperature = mergeTemperatureAndUnit(
                        weather!!.current.temperature_2m,
                        weather!!.current_units.temperature_2m
                    ),
                    showCode = true
                )


                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.LightGray.copy(alpha = 0.4f))
//                        .blur(16.dp)
                        .fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier.padding(
                            horizontal = 8.dp, vertical = 4.dp
                        ), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.schedule_24dp),
                            contentDescription = stringResource(id = R.string.app_name),
                        )

                        Text(
                            modifier = Modifier.padding(
                                horizontal = 8.dp,
                            ), text = "Hourly", fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {

                        getTodayTemperatures(weather!!).forEach { (time, temp) ->
                            Log.d("time", time)
                            WeatherDataView(
                                currentTime = time,
                                weatherIcon = Wmo.codes[weather!!.current.weather_code],
                                temperature = mergeTemperatureAndUnit(
                                    temp,
                                    weather!!.current_units.temperature_2m
                                ),
                                showCode = false
                            )
                        }
//                        for (i in 1..getTodayTemperatures(weather!!).size) {
//                            WeatherDataView(
//                                currentTime = weather!!.current.time,  //Demo.weatherResponse.current.time,
//                                weatherIcon = Wmo.codes[weather!!.current.weather_code], //Demo.weatherResponse.current.weather_code
//                                temperature = mergeTemperatureAndUnit(
//                                    weather!!.current.temperature_2m,
//                                    weather!!.current_units.temperature_2m
//                                ),
//                                showCode = false
//                            )
//                        }
                    }
                }


//            Spacer(modifier = Modifier.height(6.dp))

                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.LightGray.copy(alpha = 0.4f))
                        .fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier.padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        ), verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.calendar_month_24dp),
                            contentDescription = stringResource(id = R.string.app_name),
                        )

                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "This Week",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        for (i in 1..6) {
                            WeatherDataView(
                                currentTime = weather!!.current.time,
                                weatherIcon = Wmo.codes[weather!!.current.weather_code],
                                temperature = mergeTemperatureAndUnit(
                                    weather!!.current.temperature_2m,
                                    weather!!.current_units.temperature_2m
                                ),
                                showCode = false
                            )
                        }
                    }
//                Row(
//
//                ) {
//                    for (i in 1..6) {
//                        WeatherDataView(showCode = false)
//                    }
//                }
                }

            }

        }
    } else {
        CircularProgressIndicator()
    }


}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(

) {
    MainScreen()
}