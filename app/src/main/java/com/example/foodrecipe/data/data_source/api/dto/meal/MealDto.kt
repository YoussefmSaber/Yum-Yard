package com.example.foodrecipe.data.data_source.api.dto.meal

import com.example.foodrecipe.domain.model.Meal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealDto(
    @SerialName("recipe_id")
    val recipe_id: String,
    @SerialName("strMeal")
    val strMeal: String,
    @SerialName("strCategory")
    val strCategory: String,
    @SerialName("strArea")
    val strArea: String,
    @SerialName("strInstructions")
    val strInstructions: String,
    @SerialName("strMealThumb")
    val strMealThumb: String,
    @SerialName("strTags")
    val strTags: String?,
    @SerialName("strYoutube")
    val strYoutube: String,
    @SerialName("ingredients")
    val ingredients: String,
    @SerialName("measures")
    val measures: String,
    @SerialName("strSource")
    val strSource: String?,
    @SerialName("user_id")
    val user_id: String,
)

fun MealDto.toMeal(): Meal {
    return Meal(
        mealId = recipe_id,
        mealName = strMeal,
        mealCategory = strCategory,
        mealArea = strArea,
        mealInstructions = strInstructions,
        mealThumb = strMealThumb,
        mealTags = strTags,
        mealYoutubeVideo = strYoutube,
        mealIngredients = ingredients.split(", "),
        mealMeasures = measures.split(", "),
        userId = user_id
    )
}