package com.example.foodrecipe.presentation.componants

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.data.data_source.api.dto.recipe.RecipeComment
import com.example.foodrecipe.domain.model.recipe.Meal
import com.example.foodrecipe.presentation.componants.cards.CommentCard
import com.example.foodrecipe.presentation.componants.cards.IngredientCard
import com.example.foodrecipe.presentation.componants.cards.InstructionCard
import com.example.foodrecipe.presentation.componants.cards.SearchedRecipeCard
import com.example.foodrecipe.ui.theme.Gray3

@Composable
fun IngredientsList(ingredients: List<String>, measures: List<String>) {
    LazyColumn(horizontalAlignment = Alignment.End) {
        item {
            Text("${ingredients.size} items", fontSize = 12.sp, color = Gray3)
            Spacer(Modifier.height(16.dp))
        }
        items(ingredients.size) { index ->
            IngredientCard(
                name = ingredients[index],
                quantity = measures.getOrNull(index) ?: ""
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun InstructionsList(instructions: Map<String, String>) {
    LazyColumn(horizontalAlignment = Alignment.End) {
        item {
            Text("${instructions.size} steps", fontSize = 12.sp, color = Gray3)
            Spacer(Modifier.height(16.dp))
        }
        items(instructions.keys.toList()) { stepKey ->
            val stepContent = instructions[stepKey] ?: ""
            InstructionCard(stepKey, stepContent)
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun CommentsSection(recipeComments: List<RecipeComment>) {

    LazyColumn(horizontalAlignment = Alignment.End) {
        item {
            Text(
                "${recipeComments.size} ${if (recipeComments.size == 1) "comment" else "comments"}",
                fontSize = 12.sp, color = Gray3
            )
        }
        items(recipeComments) { comment ->
            CommentCard(comment)
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun SearchGridList(
    searchedRecipes: List<Meal>,
    navigateToDetails: (String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
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
                    SearchedRecipeCard(
                        recipe,
                        modifier = Modifier.clickable {
                            navigateToDetails(recipe.recipeId)
                        }
                    )
                }
            }
        }
    }
}