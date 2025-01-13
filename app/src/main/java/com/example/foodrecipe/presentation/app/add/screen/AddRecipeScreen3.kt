package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodrecipe.presentation.componants.GeneralTopBar

@Composable
fun AddRecipeScreen3(

) {
    Scaffold(
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