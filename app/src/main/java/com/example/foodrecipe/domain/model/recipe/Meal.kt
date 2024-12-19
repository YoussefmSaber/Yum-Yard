package com.example.foodrecipe.domain.model.recipe

import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    val recipeId: String = "",
    val recipeName: String = "",
    val recipeCategory: String = "",
    val recipeArea: String = "",
    val recipeInstructions: Map<String, String> = emptyMap(),
    val recipeThumb: String = "",
    val recipeTags: String? = null,
    val recipeYoutubeVideo: String = "",
    val recipeIngredients: List<String> = emptyList(),
    val recipeMeasures: List<String> = emptyList(),
    val userId: String = "",
)
