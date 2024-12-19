package com.example.foodrecipe.domain.usecase.recipe.filter

import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.toFilteredMeal
import com.example.foodrecipe.domain.model.recipe.FilteredMeal
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class FilterByCategoryUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<String, List<FilteredMeal>>() {
    override suspend fun execute(params: String): List<FilteredMeal> {

        return repository.filterByCategory(params).map { it.toFilteredMeal() }
    }
}