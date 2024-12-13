package com.example.foodrecipe.domain.usecase.get.listing

import com.example.foodrecipe.data.data_source.api.dto.meal_category.toMealCategory
import com.example.foodrecipe.domain.model.MealCategory
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class ListAllCategoriesUseCase(
    private val repository: MealsRepository
) : BaseUseCase<Unit,
        List<MealCategory>>() {
    override suspend fun execute(params: Unit):
            List<MealCategory> {

        return repository.listAllCategories().map { it.toMealCategory() }
    }
}
