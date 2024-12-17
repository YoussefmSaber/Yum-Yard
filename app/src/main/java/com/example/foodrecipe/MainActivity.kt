package com.example.foodrecipe

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipe.presentation.navigation.ApplicationNavigation
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import com.example.foodrecipe.ui.theme.Transparent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            SystemBarStyle.light(Color.TRANSPARENT, Color.BLACK)
        )
        installSplashScreen()
        setContent() {

            FoodRecipeTheme(
                darkTheme = false,
                dynamicColor = false
            ) {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    innerPadding
                    Surface(
                        modifier = Modifier.padding(),
                        color = Transparent
                    )
                    {
                        ApplicationNavigation(navController)
                    }
                }
            }
        }
    }
}
