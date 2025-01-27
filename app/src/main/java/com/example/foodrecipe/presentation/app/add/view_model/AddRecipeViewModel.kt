package com.example.foodrecipe.presentation.app.add.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.domain.model.recipe.AddRecipe
import com.example.foodrecipe.domain.usecase.recipe.recipe_edit.AddMealUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class AddRecipeViewModel(private val addMealUseCase: AddMealUseCase) : ViewModel() {

    private val _recipeData = MutableStateFlow(AddRecipe())
    val recipeData: StateFlow<AddRecipe> = _recipeData

    fun addIngredient(ingredient: String, measure: String) {
        val updatedIngredient = _recipeData.value.ingredients.toMutableList()
        val updatedMeasure = _recipeData.value.measure.toMutableList()
        updatedIngredient.add(ingredient)
        updatedMeasure.add(measure)
        _recipeData.value =
            _recipeData.value.copy(ingredients = updatedIngredient, measure = updatedMeasure)
    }

    fun removeStep(index: Int) {
        val currentSteps = _recipeData.value.steps

        // Split the steps string into individual steps
        val stepList = currentSteps.split(Regex("(?=Step \\d+:)")).filter { it.isNotBlank() }

        if (index in stepList.indices) {
            // Remove the step at the specified index
            val updatedSteps = stepList.toMutableList().apply { removeAt(index) }

            // Rebuild the steps string and renumber the steps
            val newSteps = updatedSteps.mapIndexed { i, step ->
                "Step ${i + 1}: ${step.substringAfter(":").trim()}"
            }.joinToString("\n")

            // Update the RecipeData
            _recipeData.value = _recipeData.value.copy(steps = newSteps)
        }
    }

    fun addStep(step: String) {
        val currentSteps = _recipeData.value.steps
        val stepCount = currentSteps.split(Regex("(?=Step \\d+:)")).size // Count existing steps
        val newStep = "Step ${stepCount + 1}: $step\n" // Format the new step
        _recipeData.value = _recipeData.value.copy(steps = currentSteps + newStep)
    }

    fun removeIngredient(index: Int) {
        val updatedIngredients = _recipeData.value.ingredients.toMutableList()
        val updatedMeasures = _recipeData.value.measure.toMutableList()
        if (index in updatedIngredients.indices) {
            updatedIngredients.removeAt(index)
            updatedMeasures.removeAt(index)
            _recipeData.value =
                _recipeData.value.copy(ingredients = updatedIngredients, measure = updatedMeasures)
        }
    }

    fun updateRecipeData(updatedData: AddRecipe) {
        _recipeData.value = updatedData
    }

    fun postRecipe() {
        viewModelScope.launch(Dispatchers.IO) {
            addMealUseCase.invoke(_recipeData.value)
        }
    }
}