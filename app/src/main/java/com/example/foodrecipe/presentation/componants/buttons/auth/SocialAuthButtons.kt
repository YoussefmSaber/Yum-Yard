package com.example.foodrecipe.presentation.componants.buttons.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.Facebook
import com.example.foodrecipe.common.assets.icons.Google
import com.example.foodrecipe.ui.theme.White

@Composable
private fun SocialAuth(icon: ImageVector, onClick: () -> Unit) {
    Card(
        colors = CardColors(
            containerColor = White,
            contentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified
        ),
        onClick = onClick,
        shape = RoundedCornerShape(25),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "$icon auth",
            modifier = Modifier
                .padding(8.dp)
                .size(32.dp)
        )
    }
}

@Composable
fun SocialAuthButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
        modifier = Modifier.fillMaxWidth()
    ) {
        SocialAuth(icon = Iconly.Google) { /* Handle Google Auth */ }
        SocialAuth(icon = Iconly.Facebook) { /* Handle Facebook Auth */ }
    }
}