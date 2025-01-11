package com.example.foodrecipe.data.data_source.api.dto.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val followers: Int,
    val image: String,
    val name: String,
    @SerialName("user_id")
    val userId: String
)