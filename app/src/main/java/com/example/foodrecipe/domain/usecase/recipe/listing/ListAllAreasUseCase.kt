package com.example.foodrecipe.domain.usecase.recipe.listing

import com.example.foodrecipe.data.data_source.api.dto.area.toArea
import com.example.foodrecipe.domain.model.Area
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class ListAllAreasUseCase(
    private val repository: RecipesRepository
) : BaseUseCase<Unit, List<Area>>() {
    override suspend fun execute(params: Unit): List<Area> {

        return repository.listAllAreas().map { it.toArea() }
    }
}