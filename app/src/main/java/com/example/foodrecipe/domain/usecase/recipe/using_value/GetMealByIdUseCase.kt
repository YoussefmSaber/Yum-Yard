package com.example.foodrecipe.domain.usecase.recipe.using_value

import com.example.foodrecipe.data.data_source.api.dto.recipe.RecipeResponseItem
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class GetMealByIdUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<String, RecipeResponseItem>() {
    override suspend fun execute(params: String): RecipeResponseItem {
        return repository.getMealById(id = params)
    }
}