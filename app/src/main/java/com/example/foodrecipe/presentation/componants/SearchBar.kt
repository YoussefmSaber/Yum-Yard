package com.example.foodrecipe.presentation.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Filter-outline`
import com.example.foodrecipe.common.assets.icons.`Search-normal-outline`
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White


@Composable
fun SearchBar(searchQuery: String, onQueryChanged: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onQueryChanged,
            textStyle = TextStyle(fontWeight = FontWeight.Normal),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Primary100,
                unfocusedBorderColor = Gray3
            ),
            placeholder = {
                Text(
                    "Search recipe",
                    fontWeight = FontWeight.Normal,
                    color = Gray3
                )
            },
            leadingIcon = {
                Image(
                    imageVector = Iconly.`Search-normal-outline`,
                    contentDescription = "Search icon"
                )
            }
        )

        Card(
            shape = RoundedCornerShape(12.dp),
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
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}