package com.example.foodrecipe.presentation.common_widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.common.fadingEdge
import com.example.foodrecipe.ui.theme.Black

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecipeImage() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Box {
            GlideImage(
                model = "https://www.themealdb.com/images/media/meals/xutquv1505330523.jpg",
                contentDescription = "Recipe Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fadingEdge(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Black),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .padding(8.dp)
                    .height(184.dp)
                    .fillMaxWidth()
            ) {
                RateCard(
                    modifier = Modifier
                )
                Save()
            }
        }
    }
}
