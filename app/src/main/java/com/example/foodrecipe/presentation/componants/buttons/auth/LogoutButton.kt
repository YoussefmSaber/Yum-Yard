package com.example.foodrecipe.presentation.componants.buttons.auth

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Logout
import com.example.foodrecipe.ui.theme.Warning

// TODO: Implement LogoutButton
@Composable
fun LogoutButton(onLogoutClickable: () -> Unit) =
    IconButton(onClick = onLogoutClickable, content = {
        Icon(
            imageVector = Iconly.Logout,
            contentDescription = "Logout Icon",
            tint = Warning,
        )
    })