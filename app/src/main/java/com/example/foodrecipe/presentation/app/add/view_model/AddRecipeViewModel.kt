package com.example.foodrecipe.presentation.app.add.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class RecipeData(
    var imageUri: String = "",
    var name: String = "",
    var area: String = "",
    var category: String = "",
    var ingredients: MutableList<Pair<String, String>> = mutableListOf(),
    var steps: MutableList<String> = mutableListOf(),
)


class AddRecipeViewModel : ViewModel() {

    private val _recipeData = MutableStateFlow(RecipeData())
    val recipeData: StateFlow<RecipeData> = _recipeData

    fun addIngredient(ingredient: String, measure: String) {
        val updatedIngredients = _recipeData.value.ingredients.toMutableList()
        updatedIngredients.add(ingredient to measure)
        _recipeData.value = _recipeData.value.copy(ingredients = updatedIngredients)
    }

    fun removeIngredient(index: Int) {
        val updatedIngredients = _recipeData.value.ingredients.toMutableList()
        if (index in updatedIngredients.indices) {
            updatedIngredients.removeAt(index)
            _recipeData.value = _recipeData.value.copy(ingredients = updatedIngredients)
        }
    }

    fun updateRecipeData(updatedData: RecipeData) {
        _recipeData.value = updatedData
    }
}