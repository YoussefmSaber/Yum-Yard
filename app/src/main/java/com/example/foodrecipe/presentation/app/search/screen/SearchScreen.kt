package com.example.foodrecipe.presentation.app.search.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.app.search.componants.SearchBar
import com.example.foodrecipe.presentation.app.search.componants.SearchItem
import com.example.foodrecipe.presentation.app.search.componants.SearchResultsHeader
import com.example.foodrecipe.presentation.app.search.componants.TopBar
import com.example.foodrecipe.presentation.app.search.view_model.SearchViewModel
import com.example.foodrecipe.ui.theme.White
import org.koin.androidx.compose.koinViewModel


@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel(),
    navigateToDetails: (String) -> Unit,
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchedRecipes by viewModel.searchedRecipes.collectAsState()

    Scaffold(
        containerColor = White,
        modifier = Modifier
            .background(White)
            .padding(16.dp),
        topBar = {
            TopBar {
            }
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
        ) {
            SearchBar(
                searchQuery = searchQuery,
                onQueryChanged = {
                    viewModel.updateSearchQuery(it)
                    Log.d("TAG", "SearchScreen: $it")
                }
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
                items(searchedRecipes, key = { it.recipeId }) { recipe ->
                    val enterTransition =
                        remember { MutableTransitionState(false).apply { targetState = true } }

                    LaunchedEffect(Unit) {
                        enterTransition.targetState = true
                    }

                    AnimatedVisibility(
                        visibleState = enterTransition,
                        enter = fadeIn() + slideInVertically { it / 2 },
                        exit = fadeOut() + slideOutVertically { it / 2 }
                    ) {
                        Box(
                            modifier = Modifier
                                .animateItem() // Smoothly repositions item when list changes
                                .fillMaxWidth()
                        ) {
                            SearchItem(
                                recipe,
                                modifier = Modifier.clickable{
                                    navigateToDetails(recipe.recipeId)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}