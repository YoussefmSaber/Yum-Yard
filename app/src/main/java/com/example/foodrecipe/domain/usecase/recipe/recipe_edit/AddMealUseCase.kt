package com.example.foodrecipe.domain.usecase.recipe.recipe_edit

import com.example.foodrecipe.domain.model.recipe.AddRecipe
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class AddMealUseCase(private val mealRepository: RecipesRepository) : BaseUseCase<AddRecipe, Unit>() {
    override suspend fun execute(params: AddRecipe) {
        mealRepository.addMeal(params)
    }
}