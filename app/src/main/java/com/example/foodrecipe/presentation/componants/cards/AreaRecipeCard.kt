package com.example.foodrecipe.presentation.componants.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.presentation.componants.buttons.SaveButton
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray2
import com.example.foodrecipe.ui.theme.Gray4

@OptIn(ExperimentalGlideComposeApi::class)
@Preview
@Composable
fun AreaRecipeCard() {
    ConstraintLayout(modifier = Modifier.padding(8.dp)) {
        val (card, image) = createRefs()
        Card(
            colors = CardColors(
                containerColor = Gray4,
                contentColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp,
                hoveredElevation = 6.dp
            ),
            modifier = Modifier
                .padding(top = 50.dp) // Adds space for the image to "float" outside
                .constrainAs(card) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(
                Modifier.padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Classic Greek Salad",
                    maxLines = 2,
                    fontSize = 14.sp,
                    color = Gray1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(140.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Text(
                        text = "by:\nMohamed Ashraf",
                        fontSize = 12.sp,
                        color = Gray2,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    SaveButton()
                }
            }
        }
        GlideImage(
            model = "https://www.themealdb.com/images/category/beef.png",
            contentDescription = "beef",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp) // Set image size
                .clip(CircleShape) // Circle shape for the image
                .border(2.dp, Gray4, CircleShape)
                .shadow(10.dp, CircleShape) // Add shadow for elevation
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

