package com.example.foodrecipe.presentation.details.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.common_widgets.BackArrow
import com.example.foodrecipe.presentation.common_widgets.Share

@Preview
@Composable
fun DetailsTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BackArrow(modifier = Modifier.clickable(onClick = { Unit }))
        Text(
            "Recipe Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Share(modifier = Modifier.clickable(onClick = { Unit }))
    }
}