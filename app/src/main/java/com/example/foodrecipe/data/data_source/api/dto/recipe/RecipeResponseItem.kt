package com.example.foodrecipe.data.data_source.api.dto.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponseItem(
    @SerialName("RecipeComments")
    val recipeComments: List<RecipeComment>,
    @SerialName("UserProfile")
    val userProfile: UserProfile,
    val ingredients: String,
    val measures: String,
    @SerialName("recipe_id")
    val recipeId: String,
    val saved: Boolean,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String,
)
