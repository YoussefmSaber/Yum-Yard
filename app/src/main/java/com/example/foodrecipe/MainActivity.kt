package com.example.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.usecase.recipe.general.GetRandomMealsUseCase
import com.example.foodrecipe.presentation.componants.SearchItem
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val getRandomMealsUseCase: GetRandomMealsUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            val meal = produceState<List<Meal>>(
                initialValue = emptyList(),
                producer = {
                    getRandomMealsUseCase.invoke(params = Unit)
                        .collect() {
                            value = it.data ?: emptyList()
                        }
                }
            )
            FoodRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding))
                    {
                        LazyColumn {
                            items(meal.value.size) {
                                SearchItem(meal.value[it])
                            }
                        }
                    }
                }
            }
        }
    }
}