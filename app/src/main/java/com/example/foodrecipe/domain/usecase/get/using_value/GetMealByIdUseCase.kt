package com.example.foodrecipe.domain.usecase.get.using_value

import com.example.foodrecipe.data.data_source.api.dto.meal.toMeal
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class GetMealByIdUseCase(
    private val repository: MealsRepository
) : BaseUseCase<String, Meal>() {
    override suspend fun execute(params: String): Meal {
        return repository.getMealById(id = params).toMeal()
    }
}