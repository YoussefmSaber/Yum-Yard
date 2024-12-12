package com.example.foodrecipe.common

object HttpRoutes {
    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1"
    const val MEALS = "$BASE_URL/search.php?f=a"
    const val MEAL_ID = "$BASE_URL/lookup.php?i="
    const val MEAL_NAME = "$BASE_URL/search.php?s="
    const val RANDOM_MEAL = "$BASE_URL/random.php"
    const val ALL_CATEGORIES_NAMES = "$BASE_URL/categories.php"
    const val LIST_ALL_CATEGORY = "$BASE_URL/filter.php?c=list"
    const val LIST_ALL_AREA = "$BASE_URL/filter.php?a=list"
    const val LIST_ALL_INGREDIENT = "$BASE_URL/filter.php?i=list"
    const val FILTER_BY_INGREDIENT = "$BASE_URL/filter.php?i="
    const val FILTER_BY_CATEGORY = "$BASE_URL/filter.php?c="
    const val FILTER_BY_AREA = "$BASE_URL/filter.php?a="
}