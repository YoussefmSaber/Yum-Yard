package com.example.foodrecipe.presentation.auth.common_componants

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun ScreenTitle(
    title: String,
    subtitle: String,
) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(title, fontWeight = FontWeight.Bold, fontSize = 35.sp, textAlign = TextAlign.Start)
        Text(
            subtitle,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
    }
}