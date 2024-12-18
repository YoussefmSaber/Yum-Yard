package com.example.foodrecipe.presentation.componants.buttons

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-left-outline`
import com.example.foodrecipe.ui.theme.Black


@Composable
fun BackArrowButton(onClick: () -> Unit, modifier: Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = Iconly.`Arrow-left-outline`,
            contentDescription = "Back arrow",
            tint = Black,
        )
    }
}