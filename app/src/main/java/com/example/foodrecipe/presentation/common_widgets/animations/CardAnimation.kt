package com.example.foodrecipe.presentation.common_widgets.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Composable
fun animations(isSaved: Boolean): SaveAnimations {
    val cardColor by animateColorAsState(
        targetValue = if (isSaved) Primary100 else White,
        label = "Card Color Animation"
    )

    val iconColor by animateColorAsState(
        targetValue = if (isSaved) White else Primary100,
        label = "Icon Color Animation"
    )

    val bounce by animateFloatAsState(
        targetValue = if (isSaved) 1.1f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessVeryLow
        ),
        label = "Bounce Animation"
    )

    val customEaseInOut = Easing { fraction ->
        if (fraction < 0.5f) {
            2 * fraction * fraction // Ease-in
        } else {
            1 - (-2 * fraction + 2) * (-2 * fraction + 2) / 2 // Ease-out
        }
    }

    val rotation by animateFloatAsState(
        targetValue = if (isSaved) 360f else 0f,
        animationSpec = tween(easing = customEaseInOut),
        label = "Rotation Animation"
    )

    return SaveAnimations(cardColor, iconColor, bounce, rotation)
}

data class SaveAnimations(
    val cardColor: Color,
    val iconColor: Color,
    val bounce: Float,
    val rotation: Float
)