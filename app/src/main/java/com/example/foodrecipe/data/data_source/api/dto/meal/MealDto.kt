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
        recipeId = recipe_id,
        recipeName = strMeal,
        recipeCategory = strCategory,
        recipeArea = strArea,
        recipeInstructions = mapInstructionsToMap(strInstructions),
        recipeThumb = strMealThumb,
        recipeTags = strTags,
        recipeYoutubeVideo = strYoutube,
        recipeIngredients = ingredients.split(", "),
        recipeMeasures = measures.split(", "),
        userId = user_id
    )
}

// Function to map instructions to a Map<String, String>
fun mapInstructionsToMap(instructions: String): Map<String, String> {
    val instructionMap = mutableMapOf<String, String>()

    // Split the instructions based on "Step X:" pattern
    val steps = instructions.split(Regex("(?=Step \\d+:)"))

    for (step in steps) {
        val trimmedStep = step.trim()

        // Skip empty or invalid steps
        if (trimmedStep.isNotEmpty()) {
            // Extract the step number (e.g., "Step 1") and the instruction content
            val stepNumber = trimmedStep.substringBefore(":").trim()
            val stepContent = trimmedStep.substringAfter(":").trim()

            // Add the step and content to the map
            instructionMap[stepNumber] = stepContent
        }
    }

    return instructionMap
}