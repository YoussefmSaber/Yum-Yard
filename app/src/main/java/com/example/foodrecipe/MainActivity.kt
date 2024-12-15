package com.example.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.usecase.recipe.general.GetMealsUseCase
import com.example.foodrecipe.domain.usecase.recipe.general.GetRandomMealsUseCase
import com.example.foodrecipe.presentation.search.screens.SearchScreen
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import com.example.foodrecipe.ui.theme.White
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {

            FoodRecipeTheme(
                darkTheme = false,
            ) {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(White)) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding))
                    {
                        SearchScreen()
                    }
                }
            }
        }
    }
}