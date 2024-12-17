package com.example.foodrecipe.presentation.app.search.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.foodrecipe.ui.theme.Gray3

@Composable
fun SearchResultsHeader(resultsCount: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text("Search Result", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        Text(
            "$resultsCount results",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Gray3
        )
    }
}