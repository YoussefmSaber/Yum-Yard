package com.example.foodrecipe.presentation.app.details.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.annotation.ExperimentalCoilApi
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.presentation.app.common_componants.animations.animations
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray2
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.White

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalCoilApi::class)
@Composable
fun ChefDetails() {
    val isFollowed = remember { mutableStateOf(false) }
    val animations = animations(isFollowed.value)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            GlideImage(
                model = "https://i.pinimg.com/736x/b0/40/e7/b040e76ad3b62145df9c938f4c96e5b8.jpg",
                contentDescription = "Chefs profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
            )
            Box(Modifier.width(8.dp))
            Column {
                Text(
                    "Chef Karim"
                )
                Text(
                    "21k followers",
                    color = Gray2,
                    fontSize = 12.sp
                )
            }
        }
        Card(
            colors = CardColors(
                containerColor = animations.followColor,
                contentColor = White,
                disabledContentColor = Gray1,
                disabledContainerColor = Gray3
            ), modifier = Modifier
                .clickable {
                    isFollowed.value = !isFollowed.value
                }
                .width(110.dp)

        ) {
            Text(
                if (isFollowed.value) "Following" else "Follow",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = animations.cardColor,

                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 12.dp)
                    .align(Alignment.CenterHorizontally),
            )
        }
    }
}