package com.example.foodrecipe.data.data_source.api.dto.meal_category

import com.example.foodrecipe.domain.model.recipe.MealCategory
import kotlinx.serialization.Serializable

@Serializable
data class MealCategoryDto(
    val strCategory: String
)

fun MealCategoryDto.toMealCategory(): MealCategory = MealCategory(strCategory)