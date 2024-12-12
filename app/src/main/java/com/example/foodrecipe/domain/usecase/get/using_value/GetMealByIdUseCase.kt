package com.example.foodrecipe.domain.usecase.get.using_value

import com.bumptech.glide.load.HttpException
import com.example.foodrecipe.common.Resource
import com.example.foodrecipe.data.data_source.api.dto.meal.toMeals
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMealByIdUseCase(
    private val repository: MealsRepository
) : BaseUseCase<String, List<Meal>>(repository) {
    override suspend fun execute(params: String): List<Meal> {
        return repository.getMealById(params).toMeals()
    }
}