package com.example.foodrecipe.domain.usecase.get.general

import com.example.foodrecipe.data.data_source.api.dto.meal.toMeals
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class GetMealsUseCase(
    private val repository: MealsRepository
) : BaseUseCase<Unit, List<Meal>>(repository) {
    override suspend fun execute(params: Unit): List<Meal> {
        return repository.getMeals().toMeals()
    }
}