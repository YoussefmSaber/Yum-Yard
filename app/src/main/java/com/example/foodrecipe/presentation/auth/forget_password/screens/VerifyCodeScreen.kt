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
import com.example.foodrecipe.presentation.componants.BackgroundImage
import com.example.foodrecipe.presentation.componants.OTPTextField
import com.example.foodrecipe.presentation.componants.ScreenTitle
import com.example.foodrecipe.presentation.componants.buttons.BackArrowButton
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton

@Preview
@Composable
fun VerifyCodeScreen(returnToEmail: () -> Unit = {}, onCLick: () -> Unit = {}) {
    val otpState = remember { mutableStateOf("") }
    Scaffold { innerPadding ->
        Box {
            BackgroundImage()
            VerifyCodeContent(innerPadding, otpState, returnToEmail, onCLick)
        }
    }
}

@Composable
private fun VerifyCodeContent(
    innerPadding: PaddingValues,
    otpState: MutableState<String>,
    returnToEmail: () -> Unit,
    resetPassword: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(
            vertical = innerPadding.calculateTopPadding(),
            horizontal = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.Start
    ) {
        BackArrowButton(onClick = returnToEmail, modifier = Modifier.padding(0.dp))
        Spacer(Modifier.height(32.dp))
        ScreenTitle(
            title = "Code Verification,",
            titleFontSize = 26,
            subtitle = "We have sent a code to your email, please enter it below.",
            subtitleFontSize = 14,
            width = 0.75F
        )
        Spacer(Modifier.height(64.dp))
        OTPTextField(otpState)
        Spacer(Modifier.height(32.dp))
        EmailAuthButton(text = "Verify code", onClick = resetPassword)
    }
}