package com.example.foodrecipe.presentation.componants.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodrecipe.common.fadingEdge
import com.example.foodrecipe.domain.model.Meal
import com.example.foodrecipe.presentation.componants.buttons.RateButton
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.White


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchedRecipeCard(meal: Meal, modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.size(180.dp).padding(0.dp)
    ) {
        Box {
            GlideImage(
                model = meal.recipeThumb,
                contentDescription = "Recipe Image",
                contentScale = ContentScale.Crop,
                // To add the fade in effect
                modifier = Modifier.fadingEdge(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 0F, // Start at the top
                        endY = Float.POSITIVE_INFINITY   // End at the bottom
                    )
                )
            )
            ConstraintLayout(
                modifier = Modifier
                    .size(180.dp)
                    .padding(8.dp)
            ) {
                val (rate, title) = createRefs()
                RateButton(modifier = Modifier
                    .constrainAs(rate) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    })

                Column(modifier = Modifier.constrainAs(title) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }) {
                    Text(
                        meal.recipeName,
                        color = White,
                        fontSize = 12.sp,
                        overflow = TextOverflow.Clip,
                        maxLines = 2
                    )
                    Text(
                        "By Chef John",
                        color = Gray3,
                        fontSize = 8.sp,
                    )
                }
            }
        }

    }
}