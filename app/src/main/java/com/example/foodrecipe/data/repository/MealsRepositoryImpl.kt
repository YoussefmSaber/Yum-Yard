package com.example.foodrecipe.data.repository

import com.example.foodrecipe.common.HttpRoutes
import com.example.foodrecipe.data.data_source.api.dto.area.AreasDto
import com.example.foodrecipe.data.data_source.api.dto.category.CategoriesDto
import com.example.foodrecipe.data.data_source.api.dto.meal_category.CategoryListDto
import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.FilteredMealsDto
import com.example.foodrecipe.data.data_source.api.dto.ingredient.IngredientsDto
import com.example.foodrecipe.data.data_source.api.dto.meal.MealsDto
import com.example.foodrecipe.domain.repository.MealsRepository
import io.ktor.client.*
import io.ktor.client.request.*

class MealsRepositoryImpl(
    private val client: HttpClient
) : MealsRepository {

    override suspend fun getMeals(): MealsDto =
        client.get(HttpRoutes.MEALS)

    override suspend fun getMealById(id: String): MealsDto =
        client.get(HttpRoutes.MEAL_BY_ID.plus(id))

    override suspend fun getMealByName(name: String): MealsDto =
        client.get(HttpRoutes.MEAL_BY_NAME.plus(name))

    override suspend fun getRandomMeal(): MealsDto =
        client.get(HttpRoutes.RANDOM_MEAL)

    override suspend fun getAllCategorize(): CategoriesDto =
        client.get(HttpRoutes.ALL_CATEGORIES)

    override suspend fun listAllCategories(): CategoryListDto =
        client.get(HttpRoutes.LIST_ALL_CATEGORY)

    override suspend fun listAllIngredients(): IngredientsDto =
        client.get(HttpRoutes.LIST_ALL_INGREDIENT)

    override suspend fun listAllAreas(): AreasDto =
        client.get(HttpRoutes.LIST_ALL_AREA)

    override suspend fun filterByIngredient(ingredient: String): FilteredMealsDto =
        client.get(HttpRoutes.FILTER_BY_INGREDIENT.plus(ingredient))

    override suspend fun filterByArea(area: String): FilteredMealsDto =
        client.get(HttpRoutes.FILTER_BY_AREA.plus(area))

    override suspend fun filterByCategory(category: String): FilteredMealsDto =
        client.get(HttpRoutes.FILTER_BY_CATEGORY.plus(category))
}