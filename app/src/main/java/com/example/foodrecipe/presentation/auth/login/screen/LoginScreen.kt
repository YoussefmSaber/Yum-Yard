package com.example.foodrecipe.presentation.auth.login.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.R
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-right-outline`
import com.example.foodrecipe.common.assets.icons.Message
import com.example.foodrecipe.common.assets.icons.Password
import com.example.foodrecipe.presentation.auth.common_componants.CustomOutlinedTextField
import com.example.foodrecipe.presentation.auth.common_componants.ScreenTitle
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.Secondary100
import com.example.foodrecipe.ui.theme.White


@Composable
fun LoginScreen(param: (String) -> Unit) {
    Scaffold(
    ) { innerPadding ->
        Box {
            Image(
                painterResource(R.drawable.soft_background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.padding(
                    vertical = innerPadding.calculateTopPadding(),
                    horizontal = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                val emailState = remember { mutableStateOf("") }
                val passwordState = remember { mutableStateOf("") }
                Spacer(Modifier.height(64.dp))
                ScreenTitle(title = "Hello,", subtitle = "Welcome Back!")
                CustomOutlinedTextField(
                    label = "Email",
                    placeholder = "Enter Email",
                    icon = Iconly.Message,
                    inputValue = emailState.value,
                    onValueChange = { emailState.value = it },
                    isPassword = false
                )
                CustomOutlinedTextField(
                    label = "Password",
                    placeholder = "Enter Password",
                    icon = Iconly.Password,
                    inputValue = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                        Log.d("TAG", "LoginScreen: $it")
                    },
                    isPassword = true
                )


                Text("Forget Password?",
                    color = Secondary100,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.clickable {
                        param("ForgetPassword")
                    })

                Button(
                    onClick = {
                        param("Login")
                    }, shape = RoundedCornerShape(10.dp),
                    colors = ButtonColors(
                        containerColor = Primary100,
                        contentColor = Color.Unspecified,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        Text("Login", color = White, fontSize = 16.sp)
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
        }

    }
}