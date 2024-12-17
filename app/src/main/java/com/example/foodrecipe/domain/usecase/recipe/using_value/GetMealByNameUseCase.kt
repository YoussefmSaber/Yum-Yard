package com.example.foodrecipe.domain.usecase.recipe.using_value

import android.util.Log
import com.example.foodrecipe.data.data_source.api.dto.meal.toMeal
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class GetMealByNameUseCase(
    private val repository: RecipesRepository,
) : BaseUseCase<String, List<Meal>>() {
    override suspend fun execute(params: String): List<Meal> {

        val response = repository.getMealByName(params).map { it.toMeal() }
        Log.d("TAG", "execute: $response")
        return response
    }
}