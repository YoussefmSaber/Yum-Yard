package com.example.foodrecipe.presentation.app.details.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.app.details.componants.ChefDetails
import com.example.foodrecipe.presentation.app.details.componants.CustomTabs
import com.example.foodrecipe.presentation.app.details.componants.DetailsTopBar
import com.example.foodrecipe.presentation.app.details.componants.IngredientCard
import com.example.foodrecipe.presentation.app.details.componants.InstructionCard
import com.example.foodrecipe.presentation.app.details.view_model.DetailsViewModel
import com.example.foodrecipe.presentation.app.common_componants.RecipeImage
import com.example.foodrecipe.ui.theme.Gray3
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = koinViewModel(),
    recipeId: String,
    onClickCallback: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope() // Coroutine scope for suspending operations

    viewModel.fetchRecipeDetails(recipeId)

    val recipe by viewModel.recipe.collectAsState()

    Column(Modifier.padding(16.dp)) {
        DetailsTopBar(onClickCallback)
        Spacer(Modifier.height(16.dp))
        RecipeImage(recipe.recipeThumb)
        Spacer(Modifier.height(16.dp))
        Text(recipe.recipeName)
        Spacer(Modifier.height(16.dp))
        ChefDetails()
        Spacer(Modifier.height(16.dp))
        CustomTabs(selectedTap = { index ->
            coroutineScope.launch {
                pagerState.animateScrollToPage(index) // Animate scroll within coroutine
            }
        })
        Spacer(Modifier.height(8.dp))

        HorizontalPager(
            pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            when (page) {
                0 -> LazyColumn(horizontalAlignment = Alignment.End) {
                    item {
                        Text(
                            "${recipe.recipeIngredients.size} items",
                            fontSize = 12.sp,
                            color = Gray3
                        )
                        Spacer(Modifier.height(16.dp))
                    }
                    items(recipe.recipeIngredients.size) {
                        IngredientCard(
                            name = recipe.recipeIngredients[it],
                            quantity = recipe.recipeMeasures[it]
                        )
                        Spacer(Modifier.height(16.dp))
                    }
                }

                1 -> LazyColumn(horizontalAlignment = Alignment.End) {
                    item {
                        Text(
                            "${recipe.recipeInstructions.size} steps",
                            fontSize = 12.sp,
                            color = Gray3
                        )
                        Spacer(Modifier.height(16.dp))
                    }
                    items(recipe.recipeInstructions.keys.toList()) { stepKey ->
                        val stepContent = recipe.recipeInstructions[stepKey] ?: ""
                        InstructionCard(
                            stepKey,
                            stepContent
                        )
                        Spacer(Modifier.height(16.dp))
                    }
                }

                2 -> Text("Comments")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}