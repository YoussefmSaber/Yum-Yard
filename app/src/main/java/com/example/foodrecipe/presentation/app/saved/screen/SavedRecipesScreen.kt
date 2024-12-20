package com.example.foodrecipe.presentation.app.saved.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.componants.ScreenTopBar
import com.example.foodrecipe.presentation.componants.cards.SavedRecipeCard

@Preview
@Composable
fun SavedRecipesScreen() {
    ScreenContent()
}

@Composable
private fun ScreenContent() {
    Column {
        ScreenTopBar("Saved recipes")
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(10) {
                SavedRecipeCard()
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}