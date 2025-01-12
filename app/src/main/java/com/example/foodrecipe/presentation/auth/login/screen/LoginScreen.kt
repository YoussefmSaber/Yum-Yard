package com.example.foodrecipe.presentation.auth.login.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.auth.login.view_model.LoginViewModel
import com.example.foodrecipe.presentation.componants.BackgroundImage
import com.example.foodrecipe.presentation.componants.LoginInputFields
import com.example.foodrecipe.presentation.componants.OrWith
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.SignupRedirect
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.buttons.auth.ForgetPasswordButton
import com.example.foodrecipe.presentation.componants.buttons.auth.SocialAuthButtons
import org.koin.androidx.compose.koinViewModel


@Composable
fun LoginScreen(param: (String) -> Unit) {

    val viewModel: LoginViewModel = koinViewModel()

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    Box {
        BackgroundImage()
        LoginContent(
            emailState = emailState,
            passwordState = passwordState,
            onSignupClick = { param("Signup") },
            onLoginClick = {

                viewModel.login(emailState.value, passwordState.value)
                param("Login")
                Log.d("asdasdasdasd", "LoginScreen: Clicked")
            },
            onForgetClick = { param("ForgetPassword") }
        )
    }
}

@Composable
fun LoginContent(
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    onSignupClick: () -> Unit,
    onLoginClick: () -> Unit,
    onForgetClick: () -> Unit,
) {
    val innerPadding = PaddingValues()
    Column(
        Modifier.padding(vertical = innerPadding.calculateTopPadding(), horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(Modifier.height(64.dp))
        ScreenTitle(
            title = "Hello,",
            titleFontSize = 35,
            subtitle = "Welcome Back!",
            subtitleFontSize = 18
        )
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
