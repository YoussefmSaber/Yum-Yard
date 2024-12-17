package com.example.foodrecipe.presentation.app.details.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.app.common_widgets.animations.animations
import com.example.foodrecipe.ui.theme.White

@Composable
fun CustomTabs(selectedTap: (Int) -> Unit) {
    val selectedIndex = remember { mutableIntStateOf(0) }

    val list = listOf("Ingredient", "Procedure", "Comments")


    TabRow(
        selectedTabIndex = selectedIndex.intValue,
        containerColor = White,
        divider = {
            Box {}
        },
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(25)),
        indicator = {
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex.intValue == index
            val animation = animations(selected)
            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(25))
                    .background(animation.cardColor)
                else Modifier
                    .clip(RoundedCornerShape(25))
                    .background(animation.cardColor),
                selected = selected,
                onClick = {
                    selectedIndex.intValue = index
                    selectedTap(index)
                },
                text = { Text(text = text, color = animation.iconColor) }
            )
        }
    }
}