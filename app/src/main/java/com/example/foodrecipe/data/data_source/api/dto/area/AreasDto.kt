package com.example.foodrecipe.data.data_source.api.dto.area

import com.example.foodrecipe.domain.model.Area

data class AreasDto(
    val meals: List<AreaDto>
)

fun AreasDto.toAreas(): List<Area> = meals.map { it.toArea() }