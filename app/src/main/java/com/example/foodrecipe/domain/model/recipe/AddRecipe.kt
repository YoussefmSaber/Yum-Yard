package com.example.foodrecipe.domain.model.recipe

import kotlinx.serialization.Serializable

@Serializable
data class AddRecipe(
    var imageUri: String = "",
    var name: String = "",
    var area: String = "",
    var category: String = "",
    var ingredients: List<String> = mutableListOf(),
    var measure: List<String> = mutableListOf(),
    var steps: String = "",
)
