package com.example.foodrecipe.data.data_source.api.dto.filtered_meals

import com.example.foodrecipe.domain.model.FilteredMeal
import kotlinx.serialization.Serializable

@Serializable
data class FilteredMealsDto(
    val meals: List<FilteredMealDto>
)

fun FilteredMealsDto.toFilteredMeals(): List<FilteredMeal> = meals.map { it.toFilteredMeal() }