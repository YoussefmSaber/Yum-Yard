package com.example.foodrecipe.domain.usecase.recipe.recipe_edit

import com.example.foodrecipe.domain.model.recipe.Meal
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class AddMealUseCase(private val mealRepository: RecipesRepository) : BaseUseCase<Meal, Unit>() {
    override suspend fun execute(params: Meal) {
        mealRepository.addMeal(params)
    }
}