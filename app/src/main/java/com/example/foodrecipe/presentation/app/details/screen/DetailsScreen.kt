package com.example.foodrecipe.presentation.app.details.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.app.details.view_model.DetailsViewModel
import com.example.foodrecipe.presentation.componants.ChefDetails
import com.example.foodrecipe.presentation.componants.CustomTabs
import com.example.foodrecipe.presentation.componants.DetailsTopBar
import com.example.foodrecipe.presentation.componants.RecipeImageSection
import com.example.foodrecipe.presentation.componants.RecipePager
import com.example.foodrecipe.presentation.componants.RecipeTitle
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = koinViewModel(),
    recipeId: String,
    onClickCallback: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    // Fetch recipe details
    viewModel.fetchRecipeDetails(recipeId)
    val recipe by viewModel.recipe.collectAsState()

    // Main Content Layout
    Column(Modifier.padding(16.dp)) {
        DetailsTopBar(onClickCallback)
        Spacer(Modifier.height(16.dp))

        RecipeImageSection(recipe.recipeThumb)
        Spacer(Modifier.height(16.dp))

        RecipeTitle(recipe.recipeName)
        Spacer(Modifier.height(16.dp))

        ChefDetails()
        Spacer(Modifier.height(16.dp))

        // Custom Tabs
        CustomTabs(selectedTap = { index ->
            coroutineScope.launch {
                pagerState.animateScrollToPage(index)
            }
        })
        Spacer(Modifier.height(8.dp))

        // Horizontal Pager
        RecipePager(pagerState, recipe)
        Spacer(Modifier.height(16.dp))
    }
}
