package com.example.foodrecipe.presentation.componants.input

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Hide
import com.example.foodrecipe.common.assets.icons.Show
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Composable
fun CustomOutlinedTextField(
    label: String,
    placeholder: String,
    icon: ImageVector,
    inputValue: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier,
) {
    // State to manage password visibility
    val isPasswordVisible = remember { mutableStateOf(isPassword) }

    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Black,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                onValueChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "$label icon",
                    modifier = modifier.size(24.dp)
                )
            },
            trailingIcon = {
                if (isPassword) {
                    AnimatedContent(
                        targetState = isPasswordVisible.value, label = "",
                        transitionSpec = {
                            (fadeIn(animationSpec = tween(300))).togetherWith(
                                fadeOut(
                                    animationSpec = tween(
                                        300
                                    )
                                )
                            )
                        }) { targetState ->
                        IconButton(
                            onClick = {
                                isPasswordVisible.value = !isPasswordVisible.value
                            },
                        ) {
                            Icon(
                                imageVector = if (targetState) Iconly.Hide else Iconly.Show,
                                contentDescription = if (targetState) "Hide password" else "Show password",
                            )
                        }
                    }
                } else {
                    Box {}
                }
            },
            shape = RoundedCornerShape(25),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Primary100,
                unfocusedBorderColor = Gray3,
                focusedLabelColor = Black,
                unfocusedTextColor = Black,
                unfocusedLeadingIconColor = Gray3,
                focusedLeadingIconColor = Primary100,
                focusedTextColor = Black
            ),
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Black
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Gray3
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(White, shape = RoundedCornerShape(25)),
            visualTransformation =
            if (isPasswordVisible.value) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}