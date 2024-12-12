package com.example.foodrecipe.domain.repository

import com.example.foodrecipe.data.data_source.api.dto.area.AreasDto
import com.example.foodrecipe.data.data_source.api.dto.category.CategoriesDto
import com.example.foodrecipe.data.data_source.api.dto.meal_category.CategoryListDto
import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.FilteredMealsDto
import com.example.foodrecipe.data.data_source.api.dto.ingredient.IngredientsDto
import com.example.foodrecipe.data.data_source.api.dto.meal.MealDto
import com.example.foodrecipe.data.data_source.api.dto.meal.MealsDto

interface MealsRepository {

    suspend fun getMeals(): MealsDto

    suspend fun getMealById(id: String): MealsDto

    suspend fun getMealByName(name: String): MealsDto

    suspend fun getRandomMeal(): MealsDto

    suspend fun getAllCategorize(): CategoriesDto

    suspend fun listAllCategories(): CategoryListDto

    suspend fun listAllIngredients(): IngredientsDto

    suspend fun listAllAreas(): AreasDto

    suspend fun filterByIngredient(ingredient: String): FilteredMealsDto

    suspend fun filterByArea(area: String): FilteredMealsDto

    suspend fun filterByCategory(category: String): FilteredMealsDto
}