package com.example.foodrecipe.data.repository

import android.util.Log
import com.example.foodrecipe.common.HttpRoutes
import com.example.foodrecipe.data.data_source.api.dto.MealDto
import com.example.foodrecipe.data.data_source.api.dto.MealsDto
import com.example.foodrecipe.domain.repository.MealsRepository
import io.ktor.client.*
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.features.get
import io.ktor.client.request.*

class MealsRepositoryImpl(
    private val client: HttpClient
) : MealsRepository {

    override suspend fun getMeals(): MealsDto = client.get(HttpRoutes.MEALS)

    override suspend fun getMealById(id: String): MealDto? = client.get {
        url(HttpRoutes.MEAL_ID.plus(id))
    }

    override suspend fun getMealByName(name: String): MealDto? =
        client.get {
            url(HttpRoutes.MEAL_NAME.plus(name))
        }
}