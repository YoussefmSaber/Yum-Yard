package com.example.foodrecipe.presentation.details.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.common_widgets.RecipeImage
import com.example.foodrecipe.presentation.details.componants.ChefDetails
import com.example.foodrecipe.presentation.details.componants.CustomTabs
import com.example.foodrecipe.presentation.details.componants.DetailsTopBar
import com.example.foodrecipe.presentation.details.componants.IngredientCard
import com.example.foodrecipe.ui.theme.Gray3
import kotlinx.coroutines.launch

@Preview
@Composable
fun DetailsScreen() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope() // Coroutine scope for suspending operations

    Column(Modifier.padding(16.dp)) {
        DetailsTopBar()
        Spacer(Modifier.height(16.dp))
        RecipeImage()
        Spacer(Modifier.height(16.dp))
        Text("Grilled Mac and Cheese Sandwich")
        Spacer(Modifier.height(16.dp))
        ChefDetails()
        Spacer(Modifier.height(16.dp))
        CustomTabs(selectedTap = { index ->
            coroutineScope.launch {
                pagerState.animateScrollToPage(index) // Animate scroll within coroutine
            }
        })
        Spacer(Modifier.height(16.dp))
        HorizontalPager(
            pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            when (page) {
                0 -> LazyColumn(horizontalAlignment = Alignment.End) {
                    item {
                        Text("10 items", fontSize = 12.sp, color = Gray3)
                        Spacer(Modifier.height(16.dp))
                    }
                    items(10) {
                        IngredientCard("Tomato", "1kg")
                        Spacer(Modifier.height(16.dp))
                    }
                }

                1 -> Text("Procedure")
                2 -> Text("Comments")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

