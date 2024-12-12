package com.example.foodrecipe.data.data_source.api.dto.category

import com.example.foodrecipe.domain.model.Category

data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

fun CategoryDto.toCategory(): Category = Category(
    id = idCategory,
    category = strCategory,
    description = strCategoryDescription,
    thumb = strCategoryThumb
)