package com.example.foodrecipe.data.data_source.api.dto.ingredient

import com.example.foodrecipe.domain.model.Ingredient
import kotlinx.serialization.Serializable

@Serializable
data class IngredientsDto(
    val meals: List<IngredientDto>
)

fun IngredientsDto.toIngredients(): List<Ingredient> = meals.map { it.toIngredient() }