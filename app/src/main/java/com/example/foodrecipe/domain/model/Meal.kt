package com.example.foodrecipe.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    val recipeId: String,
    val recipeName: String,
    val recipeCategory: String,
    val recipeArea: String,
    val recipeInstructions: Map<String, String>,
    val recipeThumb: String,
    val recipeTags: String?,
    val recipeYoutubeVideo: String,
    val recipeIngredients: List<String>,
    val recipeMeasures: List<String>,
    val userId: String,
)