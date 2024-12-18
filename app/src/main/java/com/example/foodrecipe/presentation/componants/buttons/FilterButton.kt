package com.example.foodrecipe.presentation.componants.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Filter-outline`
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Composable
fun FilterButton() {
    Card(
        shape = RoundedCornerShape(25),
        colors = CardDefaults.cardColors(
            contentColor = White,
            containerColor = Primary100,
            disabledContainerColor = Gray1,
            disabledContentColor = Gray4
        )
    ) {
        Image(
            imageVector = Iconly.`Filter-outline`,
            contentDescription = "Filter Icon",
            colorFilter = ColorFilter.tint(White),
            modifier = Modifier.padding(14.dp)
        )
    }
}