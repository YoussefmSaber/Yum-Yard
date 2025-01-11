package com.example.foodrecipe.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.foodrecipe.presentation.app.AppScreen
import com.example.foodrecipe.presentation.app.details.screen.DetailsScreen
import com.example.foodrecipe.presentation.app.saved.screen.SavedRecipesScreen
import com.example.foodrecipe.presentation.app.search.screen.SearchScreen
import com.example.foodrecipe.presentation.auth.SplashScreen
import com.example.foodrecipe.presentation.auth.forget_password.screens.ResetPasswordScreen
import com.example.foodrecipe.presentation.auth.forget_password.screens.SendCodeScreen
import com.example.foodrecipe.presentation.auth.forget_password.screens.VerifyCodeScreen
import com.example.foodrecipe.presentation.auth.login.screen.LoginScreen
import com.example.foodrecipe.presentation.auth.signup.screen.SignupScreen

@Composable
fun ApplicationNavigation(navController: NavHostController, isSplashScreen: MutableState<Boolean>) {
    NavHost(navController = navController, startDestination = Application) {
        navigation<Auth>(startDestination = Splash) {
            composable<Splash> {
                SplashScreen {
                    isSplashScreen.value = true
                    navController.navigate(Login)
                }
            }
            composable<Login> {

                isSplashScreen.value = true
                LoginScreen { destination: String ->
                    when (destination) {
                        "ForgetPassword" -> navController.navigate(ForgetPassword)
                        "Login" -> navController.navigate(Home())
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
                SendCodeScreen(
                    returnToLogin = { navController.popBackStack() },
                    onCLick = {
                        navController.navigate(VerifyCode)
                    })
            }
            composable<VerifyCode> {
                VerifyCodeScreen(
                    returnToEmail = { navController.popBackStack() },
                    onCLick = { navController.navigate(ResetPassword) }
                )
            }
            composable<ResetPassword> {
                ResetPasswordScreen(
                    returnToLogin = { navController.popBackStack() },
                    resetPassword = { navController.navigate(Login) }
                )
            }
        }
        navigation<Application>(startDestination = Details("00ce2c0e-6936-4ae1-9420-eb4190ea1ab0")) {
            composable<Search> {
                SearchScreen(
                    navigateToDetails = { navController.navigate(Details(it)) },
                )
            }
            composable<Details> {
                val recipeId = it.arguments?.getString("recipeId")
                Log.d("NAVIGATION", "ApplicationNavigation: $recipeId")
                if (recipeId != null) {
                    DetailsScreen(
                        recipeId = recipeId,
                    ) {
                        navController.popBackStack()
                    }
                }
            }
            composable<Home> {
                AppScreen(
                    onClickCallback = {
                        navController.navigate(Details(it))
                    }
                )
            }
            composable<Profile> {
//                ProfileScreen()
            }
            composable<Save> {
                SavedRecipesScreen()
            }
            composable<Add> {
//                AddRecipeScreen()
            }
        }
    }
}