package com.example.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import com.example.foodrecipe.data.data_source.api.MealsService
import com.example.foodrecipe.data.data_source.api.dto.toMeal
import com.example.foodrecipe.data.data_source.api.dto.toMeals
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.model.Meals
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

class MainActivity : ComponentActivity() {
    private val service = MealsService.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val meals = produceState<Meals>(
                initialValue = Meals(emptyList()),
                producer = {
                    value = service.getMeals().toMeals()
                }
            )
            FoodRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding))
                    {
                        LazyColumn {
                            items(meals.value.meals) {
                                Text(it.mealIngredients.size.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}
