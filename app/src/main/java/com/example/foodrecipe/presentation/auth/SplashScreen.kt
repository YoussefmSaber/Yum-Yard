package com.example.foodrecipe.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-right-outline`
import com.example.foodrecipe.common.assets.icons.`Chef-Hat`
import com.example.foodrecipe.presentation.componants.SplashImage
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Composable
fun SplashScreen(function: () -> Unit) {
    Surface {
        Box(Modifier.fillMaxSize()) {
            SplashImage()
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                LogoSection()
                AppNameSection()
                NavigateButton(function)
            }
        }
    }
}

@Composable
private fun NavigateButton(function: () -> Unit) {
    Button(
        onClick = function, shape = RoundedCornerShape(10.dp),
        colors = ButtonColors(
            containerColor = Primary100,
            contentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text("Start Cooking", color = White, fontSize = 16.sp)
            Spacer(Modifier.width(4.dp))
            Image(
                imageVector = Iconly.`Arrow-right-outline`,
                contentDescription = "Arrow",
                colorFilter = ColorFilter.tint(White),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun AppNameSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Yum Yard", color = White, fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Text(
            "Simple way to find Tasty Recipe",
            color = White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
private fun LogoSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            imageVector = Iconly.`Chef-Hat`, contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )
        Text(
            "250+ Premium Recipe",
            color = White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}