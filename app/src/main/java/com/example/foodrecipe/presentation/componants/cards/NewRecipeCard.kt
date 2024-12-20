package com.example.foodrecipe.presentation.componants.cards

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.White


@OptIn(ExperimentalGlideComposeApi::class)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = false, device = "spec:width=1080px,height=2340px,dpi=440",
    wallpaper = Wallpapers.NONE
)
@Composable
fun NewRecipeCard() {
    ConstraintLayout(
        modifier = Modifier.padding(8.dp)
    ) {
        val (card, image) = createRefs()

        Card(
            colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            ),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp,
                hoveredElevation = 6.dp
            ),
            modifier = Modifier
                .padding(top = 40.dp) // Adds space for the image to "float" outside
                .width(275.dp)
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .width(160.dp)
            ) {
                Text(
                    text = "Classic Greek Salad",
                    fontSize = 14.sp,
                    color = Gray1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    GlideImage(
                        model = "https://i.pinimg.com/736x/b0/40/e7/b040e76ad3b62145df9c938f4c96e5b8.jpg",
                        contentDescription = "chef image",
                        Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "By James Milner",
                        maxLines = 1,
                        fontSize = 12.sp,
                        color = Gray3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        // Offset Image
        GlideImage(
            model = "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg", // Replace with your image resource
            contentDescription = "Recipe image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .shadow(0.dp)
                .border(1.dp, White, CircleShape) // Optional border
                .constrainAs(image) {
                    top.linkTo(parent.top) // Negative margin to "float" the image
                    end.linkTo(card.end, margin = 16.dp)
                }
        )
    }
}


