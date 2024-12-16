package com.example.foodrecipe.presentation.details.screen

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.presentation.common_widgets.RecipeImage
import com.example.foodrecipe.presentation.details.componants.ChefDetails
import com.example.foodrecipe.presentation.details.componants.CustomTabs
import com.example.foodrecipe.presentation.details.componants.DetailsTopBar
import com.example.foodrecipe.presentation.details.componants.IngredientCard
import com.example.foodrecipe.presentation.details.componants.InstructionCard
import com.example.foodrecipe.ui.theme.Gray3
import kotlinx.coroutines.launch

@Preview
@Composable
fun DetailsScreen() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope() // Coroutine scope for suspending operations

    val recipe = Meal(
        recipeId = "asdasdasda",
        recipeName = "Grilled Mac and Cheese Sandwich",
        "asdasd",
        "asdasd",
        mapOf(
            "Step 1" to "Preheat oven to 350°F.",
            "Step 2" to "Mix flour and sugar.",
            "Step 3" to "Add eggs and stir until smooth."
        ),
        "asdasd",
        "asdasd",
        "asdasd",
        listOf(
            "Onions",
            "Red Pepper",
            "Coriander",
            "Red Chilli",
            "Garlic",
            "Dry White Wine",
            "Saffron",
            "Bay Leaf",
            "Potatoes",
            "Plum Tomatoes",
            "Cod",
            "Squid",
            "Tiger Prawns",
            "Clams",
            "Mussels",
            "Baguette"
        ),
        listOf(
            "2 finely chopped",
            "1 Diced",
            "Small bunch",
            "1 small",
            "3 cloves",
            "400ml",
            "Pinch",
            "1",
            "300g",
            "400g",
            "600g",
            "300g",
            "8",
            "500g",
            "500g",
            "1 sliced"
        ),
        "asdasd"
    )

    Column(Modifier.padding(16.dp)) {
        DetailsTopBar()
        Spacer(Modifier.height(16.dp))
        RecipeImage()
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
                            quantity = recipe.recipeIngredients[it]
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

