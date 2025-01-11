package com.example.foodrecipe.data.repository

import android.util.Log
import com.example.foodrecipe.common.TablesName
import com.example.foodrecipe.data.data_source.api.dto.recipe.RecipeResponseItem
import com.example.foodrecipe.data.data_source.api.dto.area.AreaDto
import com.example.foodrecipe.data.data_source.api.dto.category.CategoryDto
import com.example.foodrecipe.data.data_source.api.dto.filtered_meals.FilteredMealDto
import com.example.foodrecipe.data.data_source.api.dto.meal.MealDto
import com.example.foodrecipe.data.data_source.api.dto.meal_category.MealCategoryDto
import com.example.foodrecipe.domain.model.recipe.Meal
import com.example.foodrecipe.domain.repository.RecipesRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order
import kotlin.random.Random

class RecipesRepositoryImpl(
    private val client: SupabaseClient,
) : RecipesRepository {

    override suspend fun getMeals(): List<MealDto> {
        return client.from(TablesName.RECIPES).select().decodeList<MealDto>()
    }

    override suspend fun getMealById(id: String): RecipeResponseItem {

        val columns = Columns.raw(
            """
            recipe_id,
            strMeal,
            strInstructions,
            strMealThumb,
            ingredients,
            measures,
            saved,
            RecipeComments(
            id,
            comment,
            rate,
            UserProfile(
            user_id,
            name,
            followers,
            image
            )
            )
            """.trimIndent()
        )

        val res = client.from(TablesName.RECIPES)
            .select(columns = columns) {
                filter {
                    eq("recipe_id", id)
                }
            }
            .decodeSingle<RecipeResponseItem>()
        Log.d("TAG", "getMealById: $res")
        return res

    }

    override suspend fun getMealByName(name: String): List<MealDto> {
        return client.from(TablesName.RECIPES).select {
            filter {
                ilike("strMeal", "%$name%")
            }
        }.decodeList<MealDto>()
    }

    override suspend fun getRandomMeal(): List<MealDto> {
        return client.from(TablesName.RECIPES).select {
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
        return client.from(TablesName.AREA).select {
            filter {
                eq("strArea", area)
            }
        }.decodeList<FilteredMealDto>()
    }

    override suspend fun filterByCategory(category: String): List<FilteredMealDto> {
        return client.from(TablesName.CATEGORY).select {
            filter {
                eq("strCategory", category)
            }
        }.decodeList<FilteredMealDto>()
    }

    override suspend fun addMeal(meal: Meal) {
        client.from(TablesName.RECIPES).insert(meal)
    }
}