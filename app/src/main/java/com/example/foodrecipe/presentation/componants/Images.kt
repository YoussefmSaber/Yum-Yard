package com.example.foodrecipe.presentation.componants

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.R
import com.example.foodrecipe.common.fadingEdge
import com.example.foodrecipe.presentation.componants.buttons.RateButton
import com.example.foodrecipe.presentation.componants.buttons.SaveButton
import com.example.foodrecipe.ui.theme.Black


@Composable
fun SplashImage() {
    Image(
        painter = painterResource(R.drawable.splash_screen),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxWidth()
            .fadingEdge(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Black),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            ),
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.Crop,
    )
}


@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(R.drawable.soft_background),
        contentDescription = "Background",
        modifier = Modifier.fillMaxWidth(),
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecipeImageSection(imageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Box {
            Log.d("IMAGE ", "RecipeImageSection: $imageUrl")
            GlideImage(
                model = imageUrl,
                contentDescription = "Recipe Image",
                contentScale = ContentScale.Crop,
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
                RateButton(modifier = Modifier)
                SaveButton()
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ChefImage(shape: RoundedCornerShape = CircleShape) {
    GlideImage(
        model = "https://i.pinimg.com/736x/b0/40/e7/b040e76ad3b62145df9c938f4c96e5b8.jpg",
        contentDescription = "Chefs profile picture",
        modifier = Modifier
            .size(50.dp)
            .clip(shape),
    )
}