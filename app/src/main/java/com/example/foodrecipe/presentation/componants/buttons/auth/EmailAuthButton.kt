package com.example.foodrecipe.presentation.componants.buttons.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-right-outline`
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Composable
fun EmailAuthButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(25),
        colors = ButtonDefaults.buttonColors(containerColor = Primary100),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(text, color = White, fontSize = 16.sp)
            Spacer(Modifier.width(4.dp))
            Image(
                imageVector = Iconly.`Arrow-right-outline`,
                contentDescription = "Arrow",
                colorFilter = ColorFilter.tint(White),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}