package com.example.foodrecipe.common

object HttpRoutes {
    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1"
    const val MEALS = "$BASE_URL/search.php?f=a"
    const val MEAL_ID = "$BASE_URL/lookup.php?i="
    const val MEAL_NAME = "$BASE_URL/search.php?s="
}