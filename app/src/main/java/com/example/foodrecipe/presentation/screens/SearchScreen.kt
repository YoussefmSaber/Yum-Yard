package com.example.foodrecipe.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.presentation.componants.SearchBar
import com.example.foodrecipe.presentation.componants.SearchItem
import com.example.foodrecipe.presentation.componants.SearchResultsHeader
import com.example.foodrecipe.presentation.componants.TopBar
import com.example.foodrecipe.ui.theme.White

@Preview
@Composable
fun SearchScreen(meals: List<Meal> = emptyList()) {
    var searchQuery by remember { mutableStateOf("") }

    // Compute filtered items dynamically based on search query
    val filteredItems by remember(searchQuery) {
        derivedStateOf {
            meals.filter { it.mealName.contains(searchQuery, ignoreCase = true) }
        }
    }

    Scaffold(
        modifier = Modifier
            .background(White)
            .padding(16.dp),
        topBar = {
            TopBar {
                // TODO: Implement back button functionality
            }
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .background(White)
        ) {
            SearchBar(
                searchQuery = searchQuery,
                onQueryChanged = { searchQuery = it }
            )

            SearchResultsHeader(
                resultsCount = meals.size
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .background(White)
            ) {
                items(filteredItems.ifEmpty { meals }) {
                    SearchItem(meal = it)
                }
            }
        }
    }
}