package com.example.foodrecipe.presentation.componants.cards

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.common.fadingEdge
import com.example.foodrecipe.presentation.componants.buttons.RateButton
import com.example.foodrecipe.presentation.componants.buttons.SaveButton
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.White

@Preview
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SavedRecipeCard(imageUrl: String = "https://www.themealdb.com/images/media/meals/58oia61564916529.jpg") {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
            hoveredElevation = 6.dp
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(200.dp)
        ) {
            val (image, saveButton, rateButton, name, chefName) = createRefs()
            GlideImage(
                model = imageUrl,
                contentDescription = "Recipe Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .fadingEdge(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Black),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
            RateButton(modifier = Modifier.constrainAs(rateButton) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            })
            Text(
                "By Ali Gamal",
                fontSize = 10.sp,
                color = Gray4,
                modifier = Modifier.constrainAs(chefName) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                })
            Text("Recipe Name",
                fontSize = 18.sp,
                lineHeight = 18.sp,
                maxLines = 2,
                color = White,
                modifier = Modifier.constrainAs(name) {
                    bottom.linkTo(chefName.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                })
            SaveButton(modifier = Modifier.constrainAs(saveButton) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }, saved = true, onSaved = {})
        }
    }
}
