package com.example.foodrecipe.presentation.app.add.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class RecipeData(
    var imageUri: String = "",
    var name: String = "",
    var area: String = "",
    var category: String = "",
    var ingredients: MutableList<Pair<String, String>> = mutableListOf(),
    var steps: MutableList<String> = mutableListOf(),
)


class AddRecipeViewModel : ViewModel() {

    var recipeData by mutableStateOf(RecipeData())

    fun updateRecipeData(updatedData: RecipeData) {
        recipeData = updatedData
    }
}