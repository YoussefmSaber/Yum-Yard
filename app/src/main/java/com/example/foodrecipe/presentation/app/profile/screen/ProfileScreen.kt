package com.example.foodrecipe.presentation.app.profile.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.ProfileDetails
import com.example.foodrecipe.presentation.componants.ProfileHeader
import com.example.foodrecipe.presentation.componants.cards.SavedRecipeCard
import com.example.foodrecipe.ui.theme.Transparent

@Preview
@Composable
fun ProfileScreen() {
    Scaffold(
        containerColor = Transparent,
        topBar = {
            GeneralTopBar(
                title = "Profile",
                isLogoutIcon = true,
                isNavigationIcon = false,
                isShareIcon = false,
                onCLickCallBack = {}
            )
        }
    ) { innerPadding ->
        ScreenContent(innerPadding)
    }
}

@Composable
private fun ScreenContent(innerPadding: PaddingValues) {
    Column(Modifier.padding(innerPadding)) {
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                ProfileHeader()
                Spacer(modifier = Modifier.height(16.dp))
                ProfileDetails()
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "Recipes",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(10) {
                SavedRecipeCard()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

