package com.example.foodrecipe.presentation.common_widgets

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Star-fill`
import com.example.foodrecipe.ui.theme.Rating
import com.example.foodrecipe.ui.theme.Secondary20


@Composable
fun RateCard(modifier: Modifier) {
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
                modifier = Modifier.size(12.dp)
            )
            Box(Modifier.width(4.dp))
            Text("4.0", fontSize = 8.sp,)
        }
    }
}
