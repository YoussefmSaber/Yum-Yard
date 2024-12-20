package com.example.foodrecipe.presentation.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodrecipe.presentation.componants.buttons.BackArrowButton
import com.example.foodrecipe.presentation.componants.buttons.ShareButton

@Composable
fun DetailsTopBar(onCLickCallBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackArrowButton(onClick = onCLickCallBack, modifier = Modifier)
        Text(
            "Recipe Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        ShareButton(modifier = Modifier.clickable(onClick = { Unit }))
    }
}

@Composable
fun ScreenTopBar(screenName: String) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (title) = createRefs()
        Text(
            screenName,
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