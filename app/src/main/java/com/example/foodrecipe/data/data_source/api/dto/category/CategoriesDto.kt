package com.example.foodrecipe.data.data_source.api.dto.category

import com.example.foodrecipe.domain.model.Category
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesDto(
    val categories: List<CategoryDto>
)

fun CategoriesDto.toCategories(): List<Category> = categories.map { it.toCategory() }