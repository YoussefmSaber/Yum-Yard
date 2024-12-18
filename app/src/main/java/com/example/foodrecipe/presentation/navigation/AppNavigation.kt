package com.example.foodrecipe.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.foodrecipe.presentation.app.details.screen.DetailsScreen
import com.example.foodrecipe.presentation.app.home.screen.HomeScreen
import com.example.foodrecipe.presentation.app.search.screen.SearchScreen
import com.example.foodrecipe.presentation.auth.SplashScreen
import com.example.foodrecipe.presentation.auth.forget_password.screens.ResetPasswordScreen
import com.example.foodrecipe.presentation.auth.forget_password.screens.SendCodeScreen
import com.example.foodrecipe.presentation.auth.forget_password.screens.VerifyCodeScreen
import com.example.foodrecipe.presentation.auth.login.screen.LoginScreen
import com.example.foodrecipe.presentation.auth.signup.screen.SignupScreen


@Composable
fun ApplicationNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = App) {
        navigation<Auth>(startDestination = Splash) {
            composable<Splash> {
                SplashScreen {
                    navController.navigate(Login)
                }
            }

            composable<Login> {
                LoginScreen { destination: String ->
                    when (destination) {
                        "ForgetPassword" -> navController.navigate(ForgetPassword)
                        "Login" -> navController.navigate(Home)
                        "Signup" -> navController.navigate(Signup)
                    }
                }
            }
            composable<Signup> {
                SignupScreen { destination ->
                    when (destination) {
                        "Login" -> navController.navigate(Login)
                        "Signup" -> navController.navigate(VerifyCode)
                    }
                }
            }
            composable<ForgetPassword> {
                SendCodeScreen() {
                    navController.navigate(VerifyCode)
                }
            }
            composable<VerifyCode> {
                VerifyCodeScreen {
                    navController.navigate(ResetPassword)
                }
            }
            composable<ResetPassword> {
                ResetPasswordScreen {
                    navController.navigate(Login)
                }
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
            composable<Home> {
                HomeScreen()
            }
            composable<Profile> {
//                ProfileScreen()
            }
        }
    }
}
