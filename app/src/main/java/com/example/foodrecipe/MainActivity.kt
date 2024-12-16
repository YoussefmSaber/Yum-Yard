package com.example.foodrecipe

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodrecipe.presentation.details.screen.DetailsScreen
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import com.example.foodrecipe.ui.theme.White

class MainActivity : ComponentActivity() {

    val isDarkMode = true
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            SystemBarStyle.light(Color.TRANSPARENT, Color.BLACK)
        )
        installSplashScreen()
        setContent() {

            FoodRecipeTheme(
                darkTheme = false,
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(White)
                ) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding))
                    {
                        DetailsScreen()
                    }
                }
            }
        }
    }
}