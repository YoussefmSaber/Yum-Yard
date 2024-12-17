package com.example.foodrecipe.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.foodrecipe.presentation.app.details.screen.DetailsScreen
import com.example.foodrecipe.presentation.app.search.screen.SearchScreen


@Composable
fun ApplicationNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = App) {
        navigation<Auth>(startDestination = Login) {
            composable<Login> {
//                LoginScreen()
            }
            composable<Signup> {
//                SignupScreen()
            }
        }
        navigation<App>(startDestination = Search) {
            composable<Search> {
                SearchScreen {
                    navController.navigate(Details(it))
                }
            }
            composable<Details> {
                val recipeId = it.arguments?.getString("recipeId")
                if (recipeId != null) {
                    DetailsScreen(
                        recipeId = recipeId,
                    ) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}
