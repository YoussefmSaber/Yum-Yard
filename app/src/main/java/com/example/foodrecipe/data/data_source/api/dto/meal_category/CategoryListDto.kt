package com.example.foodrecipe.data.data_source.api.dto.meal_category

import com.example.foodrecipe.domain.model.MealCategory

data class CategoryListDto(
    val mealCategoryDto: List<MealCategoryDto>
)

fun CategoryListDto.toCategoryList(): List<MealCategory> =
    mealCategoryDto.map { it.toMealCategory() }