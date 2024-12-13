package com.example.foodrecipe.domain.usecase.get.general

import com.example.foodrecipe.data.data_source.api.dto.meal.toMeal
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class GetMealsUseCase(
    private val repository: MealsRepository
) : BaseUseCase<Unit, List<Meal>>() {
    override suspend fun execute(params: Unit): List<Meal> {

        return repository.getMeals().map { it.toMeal() }
    }
}