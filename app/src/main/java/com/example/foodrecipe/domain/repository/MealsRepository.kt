package com.example.foodrecipe.domain.repository

import com.example.foodrecipe.common.HttpRoutes
import com.example.foodrecipe.data.data_source.api.dto.MealDto
import com.example.foodrecipe.data.data_source.api.dto.MealsDto
import com.example.foodrecipe.data.repository.MealsRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.url

interface MealsRepository {

    suspend fun getMeals(): MealsDto

    suspend fun getMealById(id: String): MealDto?

    suspend fun getMealByName(name: String): MealDto?

}