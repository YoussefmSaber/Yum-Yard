package com.example.foodrecipe.presentation.app.details.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.app.common_widgets.BackArrow
import com.example.foodrecipe.presentation.app.common_widgets.Share

@Composable
fun DetailsTopBar(onCLickCallBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackArrow(modifier = Modifier.clickable(onClick = onCLickCallBack))
        Text(
            "Recipe Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Share(modifier = Modifier.clickable(onClick = { Unit }))
    }
}