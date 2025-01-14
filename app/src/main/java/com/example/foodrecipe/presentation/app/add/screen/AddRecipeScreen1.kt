package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Recipe
import com.example.foodrecipe.presentation.app.add.view_model.AddRecipeViewModel
import com.example.foodrecipe.presentation.app.add.view_model.RecipeData
import com.example.foodrecipe.presentation.componants.DropDownField
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.buttons.AddImageButton
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.input.CustomOutlinedTextField
import com.example.foodrecipe.ui.theme.Transparent
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddRecipeScreen1(
    onNextClick: () -> Unit,
) {
    val viewModel: AddRecipeViewModel = koinViewModel()
    val recipeState = rememberSaveable { mutableStateOf(RecipeData()) }

    Scaffold(
        containerColor = Transparent,
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
                onNextClick = {
                    viewModel.updateRecipeData(recipeState.value)
                    onNextClick()
                }
            )
        }
    }
}

@Composable
private fun ScreenContent(
    recipeState: RecipeData,
    onRecipeChange: (RecipeData) -> Unit,
    onNextClick: () -> Unit,
) {
    Column(Modifier.padding(horizontal = 16.dp, vertical = 32.dp)) {
        AddImageButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            onClick = { }
        )
        Spacer(Modifier.height(32.dp))
        CustomOutlinedTextField(
            label = "Recipe Name",
            placeholder = "Enter Recipe Name",
            icon = Iconly.Recipe,
            inputValue = recipeState.name,
            onValueChange = { updatedName ->
                onRecipeChange(recipeState.copy(name = updatedName))
            },
        )
        Spacer(Modifier.height(16.dp))
        DropDownField(
            label = "Area",
            modifier = Modifier.fillMaxWidth(),
            defaultValue = "Egypt",
            available = listOf("Egypt", "Palestine", "Syria"),
            getCurrent = { selectedArea ->
                onRecipeChange(recipeState.copy(area = selectedArea))
            }
        )
        Spacer(Modifier.height(16.dp))
        DropDownField(
            label = "Category",
            modifier = Modifier.fillMaxWidth(),
            defaultValue = "Desert",
            available = listOf("Desert", "Meat", "Chicken"),
            getCurrent = { selectedCategory ->
                onRecipeChange(recipeState.copy(category = selectedCategory))
            }
        )
        Spacer(Modifier.height(32.dp))
        EmailAuthButton(
            text = "Next",
            onClick = onNextClick
        )
    }
}
