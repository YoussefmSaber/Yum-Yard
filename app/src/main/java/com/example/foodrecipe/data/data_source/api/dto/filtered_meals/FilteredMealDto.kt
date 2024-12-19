package com.example.foodrecipe.data.data_source.api.dto.filtered_meals

import com.example.foodrecipe.domain.model.recipe.FilteredMeal
import kotlinx.serialization.Serializable

@Serializable
data class FilteredMealDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)

fun FilteredMealDto.toFilteredMeal(): FilteredMeal = FilteredMeal(
    id = idMeal,
    name = strMeal,
    thumb = strMealThumb
)