package com.example.foodrecipe.data.repository

import com.example.foodrecipe.common.TablesName
import com.example.foodrecipe.data.data_source.api.dto.area.AreaDto
import com.example.foodrecipe.data.data_source.api.dto.category.CategoryDto
import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.FilteredMealDto
import com.example.foodrecipe.data.data_source.api.dto.meal.MealDto
import com.example.foodrecipe.data.data_source.api.dto.meal_category.MealCategoryDto
import com.example.foodrecipe.domain.repository.MealsRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Order
import kotlin.random.Random

class MealsRepositoryImpl(
    private val client: SupabaseClient
) : MealsRepository {

    override suspend fun getMeals(): List<MealDto> {
        return client.from(TablesName.RECIPES).select().decodeList<MealDto>()
    }

    override suspend fun getMealById(id: String): MealDto {
        return client.from(TablesName.RECIPES).select() {
            filter {
                eq("recipe_id", id)
            }
        }.decodeSingle<MealDto>()
    }

    override suspend fun getMealByName(name: String): MealDto {
        return client.from(TablesName.RECIPES).select() {
            filter {
                eq("strMeal", name)
            }
        }.decodeSingle<MealDto>()
    }

    override suspend fun getRandomMeal(): List<MealDto> {
        return client.from(TablesName.RECIPES).select() {
            limit(5)
            order(
                "strTags",
                order = if (Random(System.currentTimeMillis()).nextInt(2) == 1) {
                    Order.ASCENDING
                } else {
                    Order.DESCENDING
                }
            )

        }.decodeList<MealDto>()
    }

    override suspend fun getAllCategorize(): List<CategoryDto> {
        TODO("Not yet implemented")
    }

    override suspend fun listAllCategories(): List<MealCategoryDto> {
        return client.from(TablesName.CATEGORY).select().decodeList<MealCategoryDto>()
    }

    override suspend fun listAllAreas(): List<AreaDto> {
        return client.from(TablesName.AREA).select().decodeList<AreaDto>()
    }

    override suspend fun filterByArea(area: String): List<FilteredMealDto> {
        return client.from(TablesName.AREA).select() {
            filter {
                eq("strArea", area)
            }
        }.decodeList<FilteredMealDto>()
    }

    override suspend fun filterByCategory(category: String): List<FilteredMealDto> {
        return client.from(TablesName.AREA).select() {
            filter {
                eq("strCategory", category)
            }
        }.decodeList<FilteredMealDto>()
    }
}