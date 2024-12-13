package com.example.foodrecipe.domain.repository

import com.example.foodrecipe.data.data_source.api.dto.area.AreaDto
import com.example.foodrecipe.data.data_source.api.dto.category.CategoryDto
import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.FilteredMealDto
import com.example.foodrecipe.data.data_source.api.dto.meal.MealDto
import com.example.foodrecipe.data.data_source.api.dto.meal_category.MealCategoryDto

interface MealsRepository {

    suspend fun getMeals(): List<MealDto>

    suspend fun getMealById(id: String): MealDto

    suspend fun getMealByName(name: String): MealDto

    suspend fun getRandomMeal(): List<MealDto>

    suspend fun getAllCategorize(): List<CategoryDto>

    suspend fun listAllCategories(): List<MealCategoryDto>

    suspend fun listAllAreas(): List<AreaDto>


    suspend fun filterByArea(area: String): List<FilteredMealDto>

    suspend fun filterByCategory(category: String): List<FilteredMealDto>
}