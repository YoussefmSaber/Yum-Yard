package com.example.foodrecipe.domain.repository

import com.example.foodrecipe.data.data_source.api.dto.AreasDto
import com.example.foodrecipe.data.data_source.api.dto.CategoriesDto
import com.example.foodrecipe.data.data_source.api.dto.CategoryListDto
import com.example.foodrecipe.data.data_source.api.dto.FilteredMealsDto
import com.example.foodrecipe.data.data_source.api.dto.IngredientsDto
import com.example.foodrecipe.data.data_source.api.dto.MealDto
import com.example.foodrecipe.data.data_source.api.dto.MealsDto
import com.example.foodrecipe.domain.model.Meals

interface MealsRepository {

    suspend fun getMeals(): MealsDto

    suspend fun getMealById(id: String): MealDto?

    suspend fun getMealByName(name: String): MealDto?

    suspend fun getRandomMeal(): MealsDto

    suspend fun getAllCategorize(): CategoriesDto

    suspend fun listAllCategories(): CategoryListDto

    suspend fun listAllIngredients(): IngredientsDto

    suspend fun listAllAreas(): AreasDto

    suspend fun filterByIngredient(ingredient: String): FilteredMealsDto

    suspend fun filterByArea(area: String): FilteredMealsDto

    suspend fun filterByCategory(category: String): FilteredMealsDto
}