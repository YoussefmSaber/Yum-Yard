package com.example.foodrecipe.domain.usecase.get.using_value

import com.example.foodrecipe.data.data_source.api.dto.meal.toMeals
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class GetMealByNameUseCase(
    private val repository: MealsRepository
) : BaseUseCase<String, List<Meal>>(repository) {
    override suspend fun execute(params: String): List<Meal> {
        return repository.getMealByName(params).toMeals()
    }
}