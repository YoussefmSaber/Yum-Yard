package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Ingredients-mix`
import com.example.foodrecipe.common.assets.icons.Measure
import com.example.foodrecipe.presentation.app.add.view_model.AddRecipeViewModel
import com.example.foodrecipe.presentation.app.add.view_model.RecipeData
import com.example.foodrecipe.presentation.componants.CustomOutlinedTextField
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.cards.AddIngredientCard
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Warning
import com.example.foodrecipe.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun AddRecipeScreen2() {
    val viewModel: AddRecipeViewModel = koinViewModel()
    val recipeState = rememberSaveable { mutableStateOf(RecipeData()) }

    Scaffold(
        containerColor = White,
        topBar = {
            GeneralTopBar(
                title = "Add Recipe",
            )
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            ScreenContent(
                recipeState = recipeState.value,
                onRecipeChange = { updatedRecipe ->
                    recipeState.value = updatedRecipe
                },
                onAddClick = {
                    viewModel.updateRecipeData(recipeState.value)
                },
                onNextClick = {
                    viewModel.updateRecipeData(recipeState.value)
                }
            )
        }
    }
}

@Composable
private fun ScreenContent(
    recipeState: RecipeData,
    onRecipeChange: (RecipeData) -> Unit,
    onAddClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    ConstraintLayout {
        val (addIngredient, ingredients) = createRefs()
        Column(modifier = Modifier.constrainAs(addIngredient) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Row {
                CustomOutlinedTextField(
                    label = "Ingredient",
                    placeholder = "Enter Ingredient",
                    icon = Iconly.`Ingredients-mix`,
                    inputValue = recipeState.name,
                    onValueChange = { updatedName ->

                    }
                )
                CustomOutlinedTextField(
                    label = "Ingredient",
                    placeholder = "Enter Ingredient",
                    icon = Iconly.Measure,
                    inputValue = recipeState.name,
                    onValueChange = { updatedName ->

                    }
                )
                Card(
                    onClick = onAddClick,
                    shape = RoundedCornerShape(25),
                    colors = CardDefaults.cardColors(
                        contentColor = White,
                        containerColor = Warning,
                        disabledContainerColor = Gray1,
                        disabledContentColor = Gray4
                    )
                ) {
                    Text(
                        "-",
                        fontSize = 20.sp,
                        color = White,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }

            }
            Spacer(Modifier.height(16.dp))
            EmailAuthButton("Next") { }
        }
        LazyColumn {
            items(10) {
                AddIngredientCard()
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}