package com.example.foodrecipe.data.data_source.api.dto.area

import com.example.foodrecipe.domain.model.Area

data class AreaDto(
    val strArea: String
)

fun AreaDto.toArea(): Area = Area(area = strArea)
