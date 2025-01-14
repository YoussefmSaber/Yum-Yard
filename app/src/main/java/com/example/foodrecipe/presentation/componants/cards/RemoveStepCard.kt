package com.example.foodrecipe.presentation.componants.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Minus
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Warning
import com.example.foodrecipe.ui.theme.White

@Preview
@Composable
fun RemoveStepCard(
    stepNumber: String = "Step 1",
    stepDetails: String = "measure".repeat(20),
    onRemove: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray4, shape = RoundedCornerShape(12.dp))
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(8f)
        ) {
            Text(stepNumber)
            Spacer(Modifier.height(8.dp))
            Text(stepDetails, color = Gray1, softWrap = true)
        }
        Spacer(Modifier.width(8.dp))
        Card(
            onClick = onRemove,
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(25),
            colors = CardDefaults.cardColors(
                contentColor = White,
                containerColor = Warning,
                disabledContainerColor = Gray1,
                disabledContentColor = Gray4
            )
        ) {
            Icon(
                imageVector = Iconly.Minus,
                contentDescription = "Remove Step",
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
            )
        }
    }
}