package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.foodrecipe.presentation.app.add.view_model.AddRecipeViewModel
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.ui.theme.Transparent
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddRecipeScreen3() {

    val viewModel: AddRecipeViewModel = koinViewModel()
    val recipeState by viewModel.recipeData.collectAsState()

    Scaffold(
        containerColor = Transparent,
        topBar = {
            GeneralTopBar(
                title = "Add Recipe",
                isNavigationIcon = true,
                onCLickCallBack = {}
            )
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {

        }
    }
}