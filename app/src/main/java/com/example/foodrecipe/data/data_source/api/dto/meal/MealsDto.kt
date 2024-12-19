package com.example.foodrecipe.data.data_source.api.dto.meal

import com.example.foodrecipe.domain.model.recipe.Meal
import kotlinx.serialization.Serializable

@Serializable
data class MealsDto(
    val meals: List<MealDto>
)

fun MealsDto.toMeals(): List<Meal> {
    return meals.map { it.toMeal() }
}