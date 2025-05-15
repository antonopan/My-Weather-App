package com.nile.pantelis.myweatherapp.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun GlassEffect(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
//            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF3E5151), Color(0xFFDECBA4))
                )
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(250.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White.copy(alpha = 0.15f))
                .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            content()
        }
    }
}
//end
@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable

fun FrostedBoxPreview() {
//    FrostedBox{
//        Text("Hello")
//
//    }
//    GlassEffect()
}