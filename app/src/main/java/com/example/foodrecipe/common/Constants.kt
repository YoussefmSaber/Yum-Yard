package com.example.foodrecipe.common

object TablesName {
    const val AREA = "Area"
    const val CATEGORY = "Category"
    const val `RECIPE-COMMENTS` = "RecipeComments"
    const val RECIPES = "Recipes"
    const val `USER-PROFILE` = "UserProfile"
}

fun String.ingredientImage(): String =
    "https://www.themealdb.com/images/ingredients/$this-Small.png"