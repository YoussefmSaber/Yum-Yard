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
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.usecase.GetMealByIdUseCase
import com.example.foodrecipe.domain.usecase.GetMealByNameUseCase
import com.example.foodrecipe.domain.usecase.GetMealsUseCase
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val getMealsUseCase: GetMealByNameUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val meal = produceState(
                initialValue = emptyList<Meal>(),
                producer = {
                    getMealsUseCase("Teriyaki Chicken Casserole").collect {
                        value = it.data ?: emptyList()
                    }
                }
            )
            FoodRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding))
                    {
                        Text(if (meal.value.isNotEmpty()) meal.value[0].mealName else "No Item found")
                    }
                }
            }
        }
    }
}
