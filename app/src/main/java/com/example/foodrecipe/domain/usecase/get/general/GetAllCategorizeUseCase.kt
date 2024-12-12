package com.example.foodrecipe.domain.usecase.get.general

import com.example.foodrecipe.data.data_source.api.dto.category.toCategories
import com.example.foodrecipe.domain.model.Category
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class GetAllCategorizeUseCase(
    private val repository: MealsRepository
) : BaseUseCase<Unit, List<Category>>(repository) {
    override suspend fun execute(params: Unit): List<Category> {
        return repository.getAllCategorize().toCategories()
    }
}