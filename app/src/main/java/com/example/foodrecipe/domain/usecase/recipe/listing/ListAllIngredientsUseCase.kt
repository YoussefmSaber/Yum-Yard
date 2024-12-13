package com.example.foodrecipe.domain.usecase.recipe.listing

import com.example.foodrecipe.data.data_source.api.dto.ingredient.toIngredients
import com.example.foodrecipe.domain.model.Ingredient
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class ListAllIngredientsUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<Unit, List<Ingredient>>(repository) {
    override suspend fun execute(params: Unit): List<Ingredient> {
        return repository.listAllIngredients().toIngredients()
    }

}