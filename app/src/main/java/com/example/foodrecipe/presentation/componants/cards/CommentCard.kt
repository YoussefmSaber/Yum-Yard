package com.example.foodrecipe.presentation.componants.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.common.transformDate
import com.example.foodrecipe.data.data_source.api.dto.recipe.RecipeComment
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CommentCard(comment: RecipeComment) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            GlideImage(
                model = comment.userProfile.image,
                contentDescription = "User profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
            Spacer(Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    comment.userProfile.name,
                    fontSize = 16.sp,
                    color = Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))
                Text(comment.createdAt.transformDate(), fontSize = 12.sp, color = Gray3)
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(comment.comment, fontSize = 14.sp, color = Gray1, fontWeight = FontWeight.Normal)
    }
}