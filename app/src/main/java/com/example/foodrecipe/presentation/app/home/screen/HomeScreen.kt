package com.example.foodrecipe.presentation.app.home.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.componants.ChefImage
import com.example.foodrecipe.presentation.componants.ScreenTitle

@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color.Transparent
    ) { innerPadding ->
        HomeScreenContent(innerPadding)

    }
}

@Composable
private fun HomeScreenContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(vertical = innerPadding.calculateTopPadding(), horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ScreenTitle(
                title = "Hello Abdalla",
                titleFontSize = 24,
                subtitle = "What are you cooking today?",
                subtitleFontSize = 14
            )
            ChefImage(RoundedCornerShape(25))
        }

        Card(
            colors = CardColors(
                containerColor = Color.Transparent,
                contentColor = Color.Unspecified,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(25),
            border = BorderStroke(1.dp, Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

        }
    }
}

