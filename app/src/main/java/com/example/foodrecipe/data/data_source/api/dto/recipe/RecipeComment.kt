package com.example.foodrecipe.data.data_source.api.dto.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeComment(
    @SerialName("UserProfile")
    val userProfile: UserProfile,
    val comment: String,
    val id: String,
    val rate: Int
)