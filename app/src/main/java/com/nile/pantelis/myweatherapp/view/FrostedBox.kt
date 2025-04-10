package com.nile.pantelis.myweatherapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun FrostedBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
    cornerRadius: Dp = 16.dp,
    contentPadding: Dp = 16.dp,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(backgroundColor)
            .padding(contentPadding)
    ) {
        content()
    }
}