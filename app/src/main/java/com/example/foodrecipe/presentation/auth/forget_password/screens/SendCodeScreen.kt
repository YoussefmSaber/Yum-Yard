package com.example.foodrecipe.presentation.auth.forget_password.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Profile
import com.example.foodrecipe.presentation.componants.BackgroundImage
import com.example.foodrecipe.presentation.componants.CustomOutlinedTextField
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.buttons.BackArrowButton
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton

@Composable
fun SendCodeScreen(returnToLogin: () -> Unit, resetPassword: () -> Unit) {
    val emailState = remember { mutableStateOf("") }
    Scaffold { innerPadding ->
        Box {
            BackgroundImage()
            SendCodeContent(innerPadding, emailState, returnToLogin, resetPassword)
        }
    }
}

@Composable
private fun SendCodeContent(
    innerPadding: PaddingValues,
    emailState: MutableState<String>,
    returnToLogin: () -> Unit,
    resetPassword: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(
            vertical = innerPadding.calculateTopPadding(),
            horizontal = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(36.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start
    ) {
        BackArrowButton(onClick = returnToLogin, modifier = Modifier.padding(0.dp))
        Spacer(Modifier.height(16.dp))
        ScreenTitle(
            title = "Forgot your password,",
            titleFontSize = 30,
            subtitle = "We will help you reset it 😊",
            subtitleFontSize = 18,
        )

        ScreenTitle(
            "Please enter your email address.",
            titleFontSize = 16,
            "You will receive a code to create a new password via email.",
            subtitleFontSize = 12,
            width = 0.90F
        )

        CustomOutlinedTextField(
            label = "Email",
            placeholder = "Enter Email",
            icon = Iconly.Profile,
            inputValue = emailState.value,
            onValueChange = { emailState.value = it },
            isPassword = false
        )

        EmailAuthButton(text = "Send Code", onClick = resetPassword)
    }
}