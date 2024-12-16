package com.example.foodrecipe.presentation.search.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.search.componants.SearchBar
import com.example.foodrecipe.presentation.search.componants.SearchItem
import com.example.foodrecipe.presentation.search.componants.SearchResultsHeader
import com.example.foodrecipe.presentation.search.componants.TopBar
import com.example.foodrecipe.presentation.search.view_model.SearchViewModel
import com.example.foodrecipe.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun SearchScreen(viewModel: SearchViewModel = koinViewModel()) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchedRecipes by viewModel.searchedRecipes.collectAsState()

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
                onQueryChanged = { viewModel.updateSearchQuery(it) }
            )

            SearchResultsHeader(
                resultsCount = searchedRecipes.size
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .background(White)
            ) {
                items(searchedRecipes) {
                    SearchItem(it)
                }
            }
        }
    }
}