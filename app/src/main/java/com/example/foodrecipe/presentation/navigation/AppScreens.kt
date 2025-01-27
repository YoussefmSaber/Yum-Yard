package com.example.foodrecipe.presentation.navigation

import kotlinx.serialization.Serializable

/**
 * This file contains all the routes used in the application.
 * The routes are used to navigate between screens.
 * The routes are also used to pass data between screens.
 */
// Application Routes
@Serializable
object Application // Route for the application screens

@Serializable
object Search  // Route for the search screen

@Serializable
data class Details(val recipeId: String)  // Route for the details screen

@Serializable
data class Home(val selectedItem: Int = 0)  // Route for the home screen

@Serializable
object Save  // Route for the save screen

@Serializable
object Profile  // Route for the profile screen

@Serializable
object AddScreen1  // Route for the add screen 1

@Serializable
object AddScreen2  // Route for the add screen 2

@Serializable
object AddScreen3  // Route for the add screen 3

@Serializable
object ReviewRecipe  // Route for review the recipe screen 1

// Authentication Routes
@Serializable
object Auth // Route for the authentication screens

@Serializable
object Splash  // Route for the splash screen

@Serializable
object Login  // Route for the login screen

@Serializable
object Signup // Route for the signup screen

@Serializable
object ForgetPassword  // Route for the forget password screen

@Serializable
object VerifyCode  // Route for the verify code screen

@Serializable
object ResetPassword  // Route for the reset password
