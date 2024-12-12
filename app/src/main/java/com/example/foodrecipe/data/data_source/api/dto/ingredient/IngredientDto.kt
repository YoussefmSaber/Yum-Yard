package com.example.foodrecipe.data.data_source.api.dto.ingredient

import com.example.foodrecipe.domain.model.Ingredient

data class IngredientDto(
    val idIngredient: String,
    val strDescription: String,
    val strIngredient: String,
    val strType: String
)

fun IngredientDto.toIngredient(): Ingredient =
    Ingredient(
        id = idIngredient,
        description = strDescription,
        ingredient = strIngredient,
        type = strType
    )
