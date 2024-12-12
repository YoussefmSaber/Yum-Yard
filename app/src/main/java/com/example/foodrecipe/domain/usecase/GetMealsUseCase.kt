package com.example.foodrecipe.domain.usecase

import com.bumptech.glide.load.HttpException
import com.example.foodrecipe.common.Resource
import com.example.foodrecipe.data.data_source.api.dto.toMeals
import com.example.foodrecipe.domain.model.Meals
import com.example.foodrecipe.domain.repository.MealsRepository
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMealsUseCase(
    private val repository: MealsRepository
) {

    operator fun invoke(): Flow<Resource<Meals>> = flow {
        try {
            emit(Resource.Loading())
            val meals = repository.getMeals().toMeals()
            emit(Resource.Success(meals))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}