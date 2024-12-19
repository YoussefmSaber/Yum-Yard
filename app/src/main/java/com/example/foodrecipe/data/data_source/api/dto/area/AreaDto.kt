package com.example.foodrecipe.data.data_source.api.dto.area

import com.example.foodrecipe.domain.model.recipe.Area
import kotlinx.serialization.Serializable

@Serializable
data class AreaDto(
    val id: String,
    val strArea: String
)

fun AreaDto.toArea(): Area = Area(area = strArea, id = id)
