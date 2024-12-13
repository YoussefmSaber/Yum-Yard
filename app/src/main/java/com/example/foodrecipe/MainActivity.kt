package com.example.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import com.example.foodrecipe.common.Iconly
import com.example.foodrecipe.common.iconly.Google
import com.example.foodrecipe.common.iconly.`Home-fill`
import com.example.foodrecipe.domain.model.Category
import com.example.foodrecipe.domain.usecase.get.general.GetAllCategorizeUseCase
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val getRandomMealsUseCase: GetAllCategorizeUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val meal = produceState(
                initialValue = emptyList<Category>(),
                producer = {
                    getRandomMealsUseCase.invoke(params = Unit).collect() {
                        value = it.data ?: emptyList()
                    }
                }
            )
            FoodRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding))
                    {
                        Column {
                            Text(if (meal.value.isNotEmpty()) meal.value[0].category else "No Item found")
                        }
                    }
                }
            }
        }
    }
}
