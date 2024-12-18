package com.example.foodrecipe.presentation.componants.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Gray4

@Composable
fun InstructionCard(
    stepNumber: String,
    stepContent: String,
) {
    Card(
        colors = CardColors(
            containerColor = Gray4,
            contentColor = Color.Unspecified,
            disabledContentColor = Gray1,
            disabledContainerColor = Gray3
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(stepNumber, fontSize = 15.sp)
            Spacer(Modifier.width(8.dp))
            Text(stepContent, color = Gray3, fontWeight = FontWeight.Normal, fontSize = 13.sp)
        }
    }
}