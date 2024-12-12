package com.example.foodrecipe.domain.usecase.get.listing

import com.example.foodrecipe.data.data_source.api.dto.ingredient.toIngredients
import com.example.foodrecipe.domain.model.Ingredient
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class ListAllIngredientsUseCase(
    private val repository: MealsRepository
) : BaseUseCase<Unit, List<Ingredient>>(repository) {
    override suspend fun execute(params: Unit): List<Ingredient> {
        return repository.listAllIngredients().toIngredients()
    }

}