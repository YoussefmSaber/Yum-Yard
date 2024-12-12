package com.example.foodrecipe.data.data_source.api.dto

import com.example.foodrecipe.domain.model.Meals
import kotlinx.serialization.Serializable

@Serializable
data class MealsDto(
    val meals: List<MealDto>
)

fun MealsDto.toMeals(): Meals {
    return Meals(
        meals = meals.map { it.toMeal() }
    )
}