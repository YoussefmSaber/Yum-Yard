package com.example.foodrecipe.presentation.componants.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Bookmark-fill`
import com.example.foodrecipe.common.assets.icons.`Bookmark-outline`
import com.example.foodrecipe.common.assets.icons.`Star-fill`
import com.example.foodrecipe.presentation.componants.animations
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Rating
import com.example.foodrecipe.ui.theme.Secondary20

@Composable
fun SaveButton() {
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
            imageVector = if (isSaved.value) Iconly.`Bookmark-fill` else Iconly.`Bookmark-outline`,
            contentDescription = "Save",
            modifier = Modifier.padding(4.dp),
            colorFilter = ColorFilter.tint(animation.iconColor)
        )
    }
}

@Composable
fun RateButton(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(50.dp),
        colors = CardColors(
            containerColor = Secondary20,
            contentColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified
        ),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = Iconly.`Star-fill`,
                contentDescription = "Rate",
                colorFilter = ColorFilter.tint(color = Rating),
                modifier = Modifier.size(14.dp)
            )
            Box(Modifier.width(4.dp))
            Text("4.0", fontSize = 12.sp)
        }
    }
}