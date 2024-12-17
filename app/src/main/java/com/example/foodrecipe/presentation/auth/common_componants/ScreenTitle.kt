package com.example.foodrecipe.presentation.auth.common_componants

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ScreenTitle(
    title: String,
    subtitle: String
) {
    Column {
        Text(title, fontWeight = FontWeight.Bold, fontSize = 35.sp)
        Text(subtitle, fontWeight = FontWeight.Normal, fontSize = 20.sp)
    }
}