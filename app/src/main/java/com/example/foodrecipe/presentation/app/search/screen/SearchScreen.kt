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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.domain.model.recipe.Meal
import com.example.foodrecipe.presentation.app.search.view_model.SearchViewModel
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.SearchBar
import com.example.foodrecipe.presentation.componants.SearchGridList
import com.example.foodrecipe.presentation.componants.SearchResultsHeader
import com.example.foodrecipe.ui.theme.Transparent
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel(),
    navigateToDetails: (String) -> Unit = {},
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchedRecipes by viewModel.searchedRecipes.collectAsState()

    Scaffold(
        containerColor = Transparent,
        modifier = Modifier.padding(horizontal = 16.dp),
        topBar = {
            GeneralTopBar(
                title = "Search",
                isNavigationIcon = false,
                isShareIcon = false,
                isLogoutIcon = false,
                onCLickCallBack = {}
            )
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