package com.example.foodrecipe.domain.usecase

import com.bumptech.glide.load.HttpException
import com.example.foodrecipe.common.Resource
import com.example.foodrecipe.data.data_source.api.dto.meal.toMeal
import com.example.foodrecipe.data.data_source.api.dto.meal.toMeals
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.MealsRepository
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMealByIdUseCase(
    private val repository: MealsRepository
) {
    operator fun invoke(id: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())
            val meal = repository.getMealById(id).toMeals()
            emit(Resource.Success(meal))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}