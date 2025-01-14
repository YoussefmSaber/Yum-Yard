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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Password
import com.example.foodrecipe.presentation.componants.CustomOutlinedTextField
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.buttons.BackArrowButton
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import com.example.foodrecipe.ui.theme.Transparent

@Preview
@Composable
fun ResetPasswordScreen(returnToLogin: () -> Unit = {}, resetPassword: () -> Unit = {}) {
    val passwordState = remember { mutableStateOf("") }
    val confPasswordState = remember { mutableStateOf("") }
    Scaffold (containerColor = Transparent){ innerPadding ->
        Box {
            ResetPasswordContent(
                innerPadding,
                passwordState,
                confPasswordState,
                returnToLogin,
                resetPassword
            )
        }
    }
}

@Composable
private fun ResetPasswordContent(
    innerPadding: PaddingValues,
    password: MutableState<String>,
    confPassword: MutableState<String>,
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
            title = "Resetting\nyour password,",
            titleFontSize = 30,
            subtitle = "please enter your new password",
            subtitleFontSize = 16,
        )

        CustomOutlinedTextField(
            label = "Password",
            placeholder = "Enter Password",
            icon = Iconly.Password,
            inputValue = password.value,
            onValueChange = { password.value = it },
        )
        CustomOutlinedTextField(
            label = "Confirm Password",
            placeholder = "Confirm Password",
            icon = Iconly.Password,
            inputValue = confPassword.value,
            onValueChange = { confPassword.value = it },
        )
        EmailAuthButton("Reset Password", onClick = resetPassword)
    }
}
