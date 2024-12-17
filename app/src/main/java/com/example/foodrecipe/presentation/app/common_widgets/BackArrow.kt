package com.example.foodrecipe.presentation.app.common_widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-left-outline`
import com.example.foodrecipe.ui.theme.Black

@Composable
fun BackArrow(modifier: Modifier) =
    Image(
        imageVector = Iconly.`Arrow-left-outline`,
        contentDescription = "Back arrow",
        colorFilter = ColorFilter.tint(Black),
        modifier = modifier
    )
