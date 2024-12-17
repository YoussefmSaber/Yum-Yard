package com.example.foodrecipe.presentation.app.details.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.common.ingredientImage
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray2
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.White

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun IngredientCard(
    name: String,
    quantity: String,
) {
    Card(
        colors = CardColors(
            containerColor = Gray4,
            contentColor = Color.Unspecified,
            disabledContentColor = Gray1,
            disabledContainerColor = Gray3
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    colors = CardColors(
                        containerColor = White,
                        contentColor = Color.Unspecified,
                        disabledContentColor = Gray1,
                        disabledContainerColor = Gray3
                    )
                ) {
                    GlideImage(
                        model = name.ingredientImage(),
                        contentDescription = "Tomato",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(8.dp)
                    )
                }
                Spacer(Modifier.width(8.dp))
                Text(name, fontSize = 16.sp)
            }

            Text(quantity, color = Gray2, fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }
    }
}