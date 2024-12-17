package com.example.foodrecipe.presentation.navigation

import kotlinx.serialization.Serializable

/**
 * This file contains all the routes used in the application.
 * The routes are used to navigate between screens.
 * The routes are also used to pass data between screens.
 */
// Application Routes
@Serializable
object App // Route for the application screens
@Serializable
object Search  // Route for the search screen
@Serializable
data class Details(val recipeId: String)  // Route for the details screen
@Serializable
object Home  // Route for the home screen
@Serializable
object Profile  // Route for the profile screen

// Authentication Routes
@Serializable
object Auth // Route for the authentication screens
@Serializable
object Login  // Route for the login screen
@Serializable
object Signup // Route for the signup screen
@Serializable
object ForgetPassword  // Route for the forget password screen