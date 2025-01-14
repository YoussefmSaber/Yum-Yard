package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.ui.theme.Transparent

@Composable
fun AddRecipeScreen3(

) {
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