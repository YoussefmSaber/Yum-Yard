package com.example.foodrecipe.presentation.auth.login.screen

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
import com.example.foodrecipe.presentation.componants.BackgroundImage
import com.example.foodrecipe.presentation.componants.LoginInputFields
import com.example.foodrecipe.presentation.componants.OrWith
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.SignupRedirect
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.buttons.auth.ForgetPasswordButton
import com.example.foodrecipe.presentation.componants.buttons.auth.SocialAuthButtons


@Composable
fun LoginScreen(param: (String) -> Unit) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    Scaffold { innerPadding ->
        Box {
            BackgroundImage()
            LoginContent(
                innerPadding = innerPadding,
                emailState = emailState,
                passwordState = passwordState,
                onSignupClick = { param("Signup") },
                onLoginClick = { param("Login") },
                onForgetClick = { param("ForgetPassword") }
            )
        }
    }
}

@Composable
fun LoginContent(
    innerPadding: PaddingValues,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    onSignupClick: () -> Unit,
    onLoginClick: () -> Unit,
    onForgetClick: () -> Unit,
) {
    Column(
        Modifier.padding(vertical = innerPadding.calculateTopPadding(), horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(Modifier.height(64.dp))
        ScreenTitle(title = "Hello,", subtitle = "Welcome Back!")
        LoginInputFields(emailState = emailState, passwordState = passwordState)
        ForgetPasswordButton(onForgetClick = onForgetClick)
        EmailAuthButton(text = "Login", onClick = onLoginClick)
        Spacer(Modifier.height(16.dp))
        OrWith("Or Login with")
        Spacer(Modifier.height(16.dp))
        SocialAuthButtons()

        SignupRedirect(onSignupClick = onSignupClick)
    }
}
