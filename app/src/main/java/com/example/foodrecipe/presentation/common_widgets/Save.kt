package com.example.foodrecipe.presentation.common_widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Bookmark-outline`
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Preview
@Composable
fun Save() {
    val isSaved = remember { mutableStateOf(false) }

    val animation = animations(isSaved.value)

    Card(
        colors = CardColors(
            containerColor = animation.cardColor,
            contentColor = Color.Unspecified,
            disabledContentColor = Gray1,
            disabledContainerColor = Gray4
        ),
        shape = RoundedCornerShape(50.dp),
        onClick = {
            isSaved.value = !isSaved.value
        },
        modifier = Modifier
            .graphicsLayer {
                scaleX = animation.bounce
                scaleY = animation.bounce
                rotationZ = animation.rotation
            }
    ) {
        Image(
            imageVector = Iconly.`Bookmark-outline`,
            contentDescription = "Save",
            modifier = Modifier.padding(4.dp),
            colorFilter = ColorFilter.tint(animation.iconColor)
        )
    }
}