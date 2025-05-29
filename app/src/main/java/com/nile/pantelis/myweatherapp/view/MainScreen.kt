package com.nile.pantelis.myweatherapp.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.nile.pantelis.myweatherapp.data.Wmo
import com.nile.pantelis.myweatherapp.data.dtos.WeatherResponse
import com.nile.pantelis.myweatherapp.data.service.WeatherRepository
import com.nile.pantelis.myweatherapp.domain.helpers.WeatherDataViewMode
import com.nile.pantelis.myweatherapp.domain.utils.getDailyTemperatures
import com.nile.pantelis.myweatherapp.domain.utils.getTodayTemperatures
import com.nile.pantelis.myweatherapp.domain.utils.mergeTemperatureAndUnit
import com.nile.pantelis.myweatherapp.domain.wmo.BackgroundGradientWMO
import com.nile.pantelis.myweatherapp.ui.theme.ClearDay1
import com.nile.pantelis.myweatherapp.ui.theme.Storm

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    latitude: Double?,
    longitude: Double?

) {



    var weather by remember { mutableStateOf<WeatherResponse?>(null) }



    LaunchedEffect(latitude, longitude) {
        if (latitude != null && longitude != null) {
            weather = WeatherRepository.getWeatherData(latitude, longitude)
        }
    }

    if (weather != null) {

        val background =
            BackgroundGradientWMO.backgroundColor[weather!!.current.weather_code]
                ?: Brush.sweepGradient(listOf(Color.LightGray, Color.Gray))

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
                    showCode = WeatherDataViewMode.MainTemp
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

                        getTodayTemperatures(weather!!).forEach { (time, code, temp) ->
                            Log.d("time", time)
                            WeatherDataView(
                                currentTime = time,
                                weatherIcon = Wmo.codes[code],
                                temperature = mergeTemperatureAndUnit(
                                    temp,
                                    weather!!.current_units.temperature_2m
                                ),
                                showCode = WeatherDataViewMode.HourlyTemp
                            )
                        }
                    }
                }


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
                        getDailyTemperatures(weather!!).forEach { (time, code, temp) ->
                            WeatherDataView(
                                currentTime = time,
                                weatherIcon = Wmo.codes[code],
                                temperature = mergeTemperatureAndUnit(
                                    temp,
                                    weather!!.current_units.temperature_2m
                                ),
                                showCode = WeatherDataViewMode.WeeklyTemp
                            )
                        }
                    }
                }

            }

        }
    } else {
       Box(
           modifier = Modifier
//               .background(ClearDay1)
               .fillMaxSize(),
           contentAlignment = Alignment.Center
       ) {
           CircularProgressIndicator(
               modifier = Modifier
                   .padding(36.dp)
                   .fillMaxSize()
                   .aspectRatio(1f),
               strokeWidth = 12.dp,
               color = Storm
           )
       }


    }


}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(

) {
    MainScreen(

        latitude = 35.3279,
        longitude = 25.1434,
    )
}