package com.example.foodrecipe.presentation.componants.buttons

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Share-outline`
import com.example.foodrecipe.ui.theme.Black

@Composable
fun ShareButton(onShareClick: () -> Unit) =
    IconButton(onClick = onShareClick, content = {
        Icon(
            imageVector = Iconly.`Share-outline`,
            contentDescription = "Share icon",
            tint = Black,
        )
    })
