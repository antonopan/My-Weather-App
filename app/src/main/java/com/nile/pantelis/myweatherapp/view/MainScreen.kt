package com.nile.pantelis.myweatherapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nile.pantelis.myweatherapp.R
import com.nile.pantelis.myweatherapp.data.Demo
import com.nile.pantelis.myweatherapp.data.Wmo
import com.nile.pantelis.myweatherapp.domain.utils.convertToDayName

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.LightGray)
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
                modifier = Modifier
                    .fillMaxWidth()
//                    .background(Color.Gray)
                ,
                showCode = true
            )
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(Color.Gray)
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.schedule_24dp),
                        contentDescription = stringResource(id = R.string.app_name),
                    )

                    Text(
                        modifier = Modifier
                            .padding(
                                horizontal = 8.dp,
                            ),
                        text = "Hourly",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Row(
                    modifier=Modifier
                        .horizontalScroll(rememberScrollState())
                ) {
                    for (i in 1..12) {
                        WeatherDataView(showCode = false)
                    }
                }
            }



//            Spacer(modifier = Modifier.height(6.dp))

            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color.Gray)
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .padding(
                            horizontal = 8.dp,
//                            vertical = 4.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
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

                ) {
                    for (i in 1..6) {
                        WeatherDataView(showCode = false)
                    }
                }
            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(

) {
    MainScreen()
}