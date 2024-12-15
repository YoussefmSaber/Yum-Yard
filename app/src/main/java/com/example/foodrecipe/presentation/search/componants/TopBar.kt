package com.example.foodrecipe.presentation.search.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-left-outline`
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.White


@Composable
fun TopBar(backClicked: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        val (backArrow, title) = createRefs()

        Image(
            imageVector = Iconly.`Arrow-left-outline`,
            contentDescription = "Back arrow",
            colorFilter = ColorFilter.tint(Black),
            modifier = Modifier
                .constrainAs(backArrow) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .clickable {
                    // TODO: Implement back button functionality
                }
        )

        Text(
            "Search recipes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}