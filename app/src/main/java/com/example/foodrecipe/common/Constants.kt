package com.example.foodrecipe.common

import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Bookmark-fill`
import com.example.foodrecipe.common.assets.icons.`Bookmark-outline`
import com.example.foodrecipe.common.assets.icons.`Home-fill`
import com.example.foodrecipe.common.assets.icons.`Home-outline`
import com.example.foodrecipe.common.assets.icons.`Plus-fill`
import com.example.foodrecipe.common.assets.icons.`Plus-outline`
import com.example.foodrecipe.common.assets.icons.Profile
import com.example.foodrecipe.common.assets.icons.`Profile-fill`
import com.example.foodrecipe.common.assets.icons.`Search-fill`
import com.example.foodrecipe.common.assets.icons.`Search-outline`
import com.example.foodrecipe.domain.model.BottomNavigationItem

object TablesName {
    const val AREA = "Area"
    const val CATEGORY = "Category"
    const val `RECIPE-COMMENTS` = "RecipeComments"
    const val RECIPES = "Recipes"
    const val `USER-PROFILE` = "UserProfile"
}

val BottomNavigationItems = listOf(
    BottomNavigationItem(Iconly.`Home-fill`, Iconly.`Home-outline`, "Home", "Home"),
    BottomNavigationItem(Iconly.`Bookmark-fill`, Iconly.`Bookmark-outline`, "Saved", "Saved"),
    BottomNavigationItem(Iconly.`Search-fill`, Iconly.`Search-outline`, "Search", "Search"),
    BottomNavigationItem(Iconly.`Plus-fill`, Iconly.`Plus-outline`, "Add", "Add"),
    BottomNavigationItem(Iconly.`Profile-fill`, Iconly.Profile, "Profile", "Profile")
)