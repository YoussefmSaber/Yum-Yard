package com.example.foodrecipe.presentation.app.search.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.presentation.app.search.view_model.SearchViewModel
import com.example.foodrecipe.presentation.componants.SearchBar
import com.example.foodrecipe.presentation.componants.SearchGridList
import com.example.foodrecipe.presentation.componants.SearchResultsHeader
import com.example.foodrecipe.presentation.componants.SearchTopBar
import org.koin.androidx.compose.koinViewModel


@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel(),
    backToHome: () -> Unit,
    navigateToDetails: (String) -> Unit,
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchedRecipes by viewModel.searchedRecipes.collectAsState()

    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier.padding(horizontal = 16.dp),
        topBar = {
            SearchTopBar (backClicked = backToHome)
        }
    ) { innerPadding ->
        SearchScreenContent(
            innerPadding = innerPadding,
            searchQuery = searchQuery,
            viewModel = viewModel,
            searchedRecipes = searchedRecipes,
            navigateToDetails = navigateToDetails
        )
    }
}

@Composable
private fun SearchScreenContent(
    innerPadding: PaddingValues,
    searchQuery: String,
    viewModel: SearchViewModel,
    searchedRecipes: List<Meal>,
    navigateToDetails: (String) -> Unit,
) {
    Column(Modifier.padding(innerPadding)) {
        SearchBar(
            searchQuery = searchQuery,
            onQueryChanged = {
                viewModel.updateSearchQuery(it)
                Log.d("TAG", "SearchScreen: $it")
            }
        )
        SearchResultsHeader(resultsCount = searchedRecipes.size)
        SearchGridList(searchedRecipes, navigateToDetails)
    }
}