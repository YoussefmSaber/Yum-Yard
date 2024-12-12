package com.example.foodrecipe.domain.repository

import android.util.Log
import com.example.foodrecipe.common.HttpRoutes
import com.example.foodrecipe.data.data_source.api.MealsService
import com.example.foodrecipe.data.data_source.api.dto.MealDto
import com.example.foodrecipe.data.data_source.api.dto.MealsDto
import io.ktor.client.*
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.*

class MealsServiceImpl(
    private val client: HttpClient
) : MealsService {
    override suspend fun getMeals(): MealsDto {
        return try {
            client.get(HttpRoutes.MEALS)
        } catch (e: RedirectResponseException) {
            // 3xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            MealsDto(emptyList())
        } catch (e: ClientRequestException) {
            // 4xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            MealsDto(emptyList())
        } catch (e: ServerResponseException) {
            // 5xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            MealsDto(emptyList())
        } catch (e: Exception) {
            //problem with the device
            Log.d("Error Fetching", "getMeals: ${e.message}")
            MealsDto(emptyList())
        }
    }

    override suspend fun getMealById(id: String): MealDto? {
        return try {
            client.get {
                url(HttpRoutes.MEAL_ID.plus(id))
            }
        } catch (e: RedirectResponseException) {
            // 3xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            //problem with the device
            Log.d("Error Fetching", "getMeals: ${e.message}")
            null
        }
    }

    override suspend fun getMealByName(name: String): MealDto? {
        return try {
            client.get {
                url(HttpRoutes.MEAL_NAME.plus(name))
            }
        } catch (e: RedirectResponseException) {
            // 3xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5xx
            Log.d("Error Fetching", "getMeals: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            //problem with the device
            Log.d("Error Fetching", "getMeals: ${e.message}")
            null
        }
    }
}