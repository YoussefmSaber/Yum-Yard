package com.example.foodrecipe.presentation.auth.signup.screen

import androidx.compose.foundation.layout.Arrangement
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
import com.example.foodrecipe.presentation.componants.LoginRedirect
import com.example.foodrecipe.presentation.componants.OrWith
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.SignupInputFields
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.buttons.auth.SocialAuthButtons
import com.example.foodrecipe.ui.theme.Transparent

@Composable
fun SignupScreen(param: (String) -> Unit) {
    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confPasswordState = remember { mutableStateOf("") }

    Scaffold(containerColor = Transparent) { innerPadding ->
        SignupContent(
            innerPadding = innerPadding,
            nameState = nameState,
            emailState = emailState,
            passwordState = passwordState,
            confPasswordState = confPasswordState,
            onSignupClick = { param("Signup") },
            onLoginClick = { param("Login") }
        )
    }
}


@Composable
fun SignupContent(
    innerPadding: PaddingValues,
    nameState: MutableState<String>,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    confPasswordState: MutableState<String>,
    onSignupClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        Modifier
            .padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(Modifier.height(32.dp))
        ScreenTitle(
            title = "Create an account,",
            titleFontSize = 24,
            subtitle = "Let’s help you set up your account, it won’t take long.",
            subtitleFontSize = 16
        )

        SignupInputFields(
            nameState = nameState,
            emailState = emailState,
            passwordState = passwordState,
            confPasswordState = confPasswordState
        )

        Spacer(Modifier.height(16.dp))
        EmailAuthButton(text = "Sign up", onClick = onSignupClick)

        Spacer(Modifier.height(16.dp))
        OrWith("Or Sign up with")
        SocialAuthButtons()

        LoginRedirect(onLoginClick)
    }
}




