package com.example.foodrecipe.presentation.componants.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.componants.SaveAnimations
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.White

@Composable
fun FollowButton(animations: SaveAnimations, isFollowed: MutableState<Boolean>) {
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
