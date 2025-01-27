package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.foodrecipe.domain.model.recipe.AddRecipe
import com.example.foodrecipe.presentation.app.add.view_model.AddRecipeViewModel
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.IngredientInputRow
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.cards.RemoveIngredientCard
import com.example.foodrecipe.ui.theme.Transparent
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddRecipeScreen2(
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
) {
    val viewModel: AddRecipeViewModel = koinViewModel()
    val recipeState by viewModel.recipeData.collectAsState()

    Scaffold(
        containerColor = Transparent,
        topBar = {
            GeneralTopBar(
                title = "Add Recipe",
                isNavigationIcon = true,
                onCLickCallBack = onPreviousClick
            )
        }
    ) { innerPadding ->
        ScreenContent(
            innerPadding,
            recipeState = recipeState,
            onAddClick = { ingredient, measure ->
                viewModel.addIngredient(ingredient, measure)
            },
            onRemoveClick = { index ->
                viewModel.removeIngredient(index)
            },
            onNextClick = onNextClick
        )

    }
}

@Composable
private fun ScreenContent(
    innerPadding: PaddingValues,
    recipeState: AddRecipe,
    onAddClick: (String, String) -> Unit,
    onRemoveClick: (Int) -> Unit,
    onNextClick: () -> Unit,
) {
    var newIngredient by remember { mutableStateOf("") }
    var newMeasure by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            val (list, buttons) = createRefs()
            val horizontalCenterGuideline = createGuidelineFromTop(0.75f)
            Column(
                modifier = Modifier.constrainAs(list) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(horizontalCenterGuideline)
                    height = Dimension.fillToConstraints
                }
            ) {
                LazyColumn {
                    itemsIndexed(
                        recipeState.ingredients,
                        key = { _, item -> item.hashCode() }) { index, ingredient ->
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically(),
                        ) {
                            Box(modifier = Modifier.animateItem()) {
                                RemoveIngredientCard(
                                    ingredient = ingredient,
                                    measure = recipeState.measure[index],
                                    onRemove = { onRemoveClick(index) }
                                )
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.constrainAs(buttons) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                IngredientInputRow(
                    ingredient = newIngredient,
                    measure = newMeasure,
                    onIngredientChange = { newIngredient = it },
                    onMeasureChange = { newMeasure = it },
                    onAddClick = {
                        if (newIngredient.isNotBlank() && newMeasure.isNotBlank()) {
                            onAddClick(newIngredient, newMeasure)
                            newIngredient = ""
                            newMeasure = ""
                        }
                    }
                )
                Spacer(Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(0.6f)) {
                    EmailAuthButton("Next", onNextClick)
                }
            }
        }
    }
}