package com.example.foodrecipe.domain.usecase.recipe.listing

import com.example.foodrecipe.data.data_source.api.dto.meal_category.toMealCategory
import com.example.foodrecipe.domain.model.recipe.MealCategory
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class ListAllCategoriesUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<Unit,
        List<MealCategory>>() {
    override suspend fun execute(params: Unit):
            List<MealCategory> {

        return repository.listAllCategories().map { it.toMealCategory() }
    }
}
