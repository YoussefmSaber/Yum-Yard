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
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.data.data_source.api.dto.toMeals
import com.example.foodrecipe.di.appModule
import com.example.foodrecipe.domain.model.Meals
import com.example.foodrecipe.domain.usecase.GetMealsUseCase
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    private val getMealsUseCase: GetMealsUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val meals = produceState(
                initialValue = Meals(emptyList()),
                producer = {
                    getMealsUseCase().collect {
                        value = it.data ?: Meals(emptyList())
                    }
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
