package com.example.foodrecipe.domain.usecase.get.filter

import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.toFilteredMeal
import com.example.foodrecipe.domain.model.FilteredMeal
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class FilterByIngredientUseCase(
    private val repository: MealsRepository
) : BaseUseCase<String, List<FilteredMeal>>() {
    override suspend fun execute(params: String): List<FilteredMeal> {
        return repository.filterByArea(params).map { it.toFilteredMeal() }
    }

}