package com.example.foodrecipe.domain.usecase.get.listing

import com.example.foodrecipe.data.data_source.api.dto.area.toArea
import com.example.foodrecipe.domain.model.Area
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.BaseUseCase

class ListAllAreasUseCase(
    private val repository: MealsRepository
) : BaseUseCase<Unit, List<Area>>() {
    override suspend fun execute(params: Unit): List<Area> {

        return repository.listAllAreas().map { it.toArea() }
    }
}