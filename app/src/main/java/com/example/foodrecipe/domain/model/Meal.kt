package com.example.foodrecipe.domain.model

data class Meal(
    val mealId: String,
    val mealName: String,
    val mealCategory: String,
    val mealArea: String,
    val mealInstructions: String,
    val mealThumb: String,
    val mealTags: String?,
    val mealYoutubeVideo: String,
    val mealIngredients: List<String>,
    val mealMeasures: List<String>
)
