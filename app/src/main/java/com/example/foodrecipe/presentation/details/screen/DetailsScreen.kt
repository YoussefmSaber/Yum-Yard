package com.example.foodrecipe.presentation.details.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.common_widgets.RecipeImage
import com.example.foodrecipe.presentation.details.componants.DetailsTopBar

@Preview
@Composable
fun DetailsScreen() {
    Column(Modifier.padding(16.dp)) {
        DetailsTopBar()
        RecipeImage()
    }
}