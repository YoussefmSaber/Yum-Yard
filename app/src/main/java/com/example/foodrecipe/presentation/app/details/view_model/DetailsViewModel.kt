package com.example.foodrecipe.presentation.app.details.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.data.data_source.api.dto.recipe.RecipeResponseItem
import com.example.foodrecipe.domain.usecase.recipe.using_value.GetMealByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val getRecipeById: GetMealByIdUseCase) : ViewModel() {

    private val _recipe = MutableStateFlow<RecipeResponseItem?>(null)
    val recipe: StateFlow<RecipeResponseItem?> = _recipe

    fun fetchRecipeDetails(recipeId: String) {
        viewModelScope.launch {
            getRecipeById.invoke(recipeId).collect { resource ->
                resource.data?.let { data ->
                    _recipe.value = data
                } ?: run {
                    Log.d("TAG", "fetchRecipeDetails: ${resource.message}")
                }
            }
        }
    }
}