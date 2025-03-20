package com.nile.pantelis.myweatherapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    .background(Color.Gray),
                showCode = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
//                .fillMaxWidth()
            ) {
                for (i in 1..6) {
                    WeatherDataView(showCode = false)
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