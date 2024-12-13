package com.example.foodrecipe.domain.usecase.recipe.general

import com.example.foodrecipe.data.data_source.api.dto.category.toCategory
import com.example.foodrecipe.domain.model.Category
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class GetAllCategorizeUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<Unit, List<Category>>() {
    override suspend fun execute(params: Unit): List<Category> {

        return repository.getAllCategorize().map { it.toCategory() }
    }
}