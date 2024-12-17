package com.example.foodrecipe

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipe.presentation.details.screen.DetailsScreen
import com.example.foodrecipe.presentation.search.screen.SearchScreen
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import com.example.foodrecipe.ui.theme.White
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            SystemBarStyle.light(Color.WHITE, Color.BLACK)
        )
        installSplashScreen()
        setContent() {

            FoodRecipeTheme(
                darkTheme = false,
            ) {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(White)
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = White
                    )
                    {
                        NavHost(navController = navController, startDestination = Search) {
                            composable<Search> {
                                SearchScreen(navController = navController)
                            }
                            composable<Details> {
                                val recipeId = it.arguments?.getString("recipeId")
                                if (recipeId != null) {
                                    DetailsScreen(
                                        recipeId = recipeId,
                                        navController = navController
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object Search

@Serializable
data class Details(val recipeId: String)