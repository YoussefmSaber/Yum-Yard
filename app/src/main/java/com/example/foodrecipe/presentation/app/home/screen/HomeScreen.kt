package com.example.foodrecipe.presentation.app.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.componants.ChefImage
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.SearchInputField
import com.example.foodrecipe.presentation.componants.cards.AreaRecipeCard
import com.example.foodrecipe.presentation.componants.cards.NewRecipeCard

@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            GeneralTopBar(
                title = "",
                isNavigationIcon = false,
                isShareIcon = false,
                isLogoutIcon = false,
            )
        }
    ) { innerPadding ->
        HomeScreenContent(innerPadding, {

        })
    }
}

@Composable
private fun HomeScreenContent(innerPadding: PaddingValues, navigateToSearch: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(vertical = innerPadding.calculateTopPadding())
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            ScreenTitle(
                title = "Hello Abdalla",
                titleFontSize = 24,
                subtitle = "What are you cooking today?",
                subtitleFontSize = 14
            )
            ChefImage(RoundedCornerShape(25))
        }
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            SearchInputField(navigateToSearch = navigateToSearch, maxWidth = 1F)
        }

        LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
            items(10) {
                AreaRecipeCard()
            }
        }
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                "New Recipes",
                fontSize = 16.sp,
                color = Color.Black,
            )
        }

        LazyRow(contentPadding = PaddingValues(start = 8.dp)) {
            items(10) {
                NewRecipeCard()
            }
        }
    }
}

