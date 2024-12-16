package com.example.foodrecipe.presentation.common_widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.common.fadingEdge
import com.example.foodrecipe.ui.theme.Black

@Preview
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BannerImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fadingEdge(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Black),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
    ) {
        GlideImage(
            model = "",
            contentDescription = "Recipe Image",
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
        ) {
            RateCard(
                modifier = Modifier.shadow(elevation = 5.dp)
            )
        }
    }
}
