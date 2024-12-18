package com.example.foodrecipe.presentation.componants.buttons.auth

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.ui.theme.Secondary100

@Composable
fun ForgetPasswordButton(onForgetClick: () -> Unit) {
    TextButton(
        onClick = onForgetClick,
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            "Forget Password?",
            color = Secondary100,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
        )
    }
}
