package com.example.foodrecipe.presentation.auth.signup.screen

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
import com.example.foodrecipe.presentation.componants.LoginRedirect
import com.example.foodrecipe.presentation.componants.OrWith
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.SignupInputFields
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.presentation.componants.buttons.auth.SocialAuthButtons

@Composable
fun SignupScreen(param: (String) -> Unit) {
    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confPasswordState = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Box {
            BackgroundImage()
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
                vertical = innerPadding.calculateTopPadding(),
                horizontal = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(Modifier.height(32.dp))
        ScreenTitle(title = "Hello,", subtitle = "Welcome Back!")

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




