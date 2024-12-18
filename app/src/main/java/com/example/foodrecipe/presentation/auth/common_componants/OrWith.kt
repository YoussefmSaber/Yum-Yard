package com.example.foodrecipe.presentation.auth.common_componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.ui.theme.Gray3

@Preview(showBackground = true)
@Composable
fun OrWith(text: String = "Or with") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f).width(50.dp),
            color = Gray3
        )
        Spacer(Modifier.width(16.dp))
        Text(text, color = Gray3, fontWeight = FontWeight.Normal, fontSize = 14.sp)
        Spacer(Modifier.width(16.dp))
        HorizontalDivider(
            modifier = Modifier
                .weight(1f).width(50.dp),
            color = Gray3
        )
    }
}