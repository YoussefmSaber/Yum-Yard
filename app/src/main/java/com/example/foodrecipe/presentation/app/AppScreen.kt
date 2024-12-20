package com.example.foodrecipe.presentation.app

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.foodrecipe.presentation.app.home.screen.HomeScreen
import com.example.foodrecipe.presentation.app.search.screen.SearchScreen
import com.example.foodrecipe.presentation.componants.NavBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppScreen(onClickCallback: (String) -> Unit, initialSelectedItem: Int = 0) {
    var selectedItem by remember { mutableIntStateOf(initialSelectedItem) }
    val pagerState = rememberPagerState(pageCount = { 5 }, initialPage = selectedItem)
    val scope = rememberCoroutineScope()

    val updatedOnClickCallback: (String) -> Unit = {
        onClickCallback(it)
        selectedItem = 0
        scope.launch {
            pagerState.animateScrollToPage(0)
        }
    }

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            NavBar(selectedItem) { index ->
                scope.launch {
                    selectedItem = index
                    pagerState.animateScrollToPage(index)
                }
            }
        }
    ) { innerPadding ->
        ScreenSwitcher(pagerState, innerPadding, updatedOnClickCallback, scope)
    }
}

@Composable
private fun ScreenSwitcher(
    pagerState: PagerState,
    innerPadding: PaddingValues,
    onClickCallback: (String) -> Unit,
    scope: CoroutineScope,
) {
    HorizontalPager(
        state = pagerState,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding,
        userScrollEnabled = false,
    ) { page ->
        when (page) {
            0 -> HomeScreen()
            1 -> Text(text = "Saved")
            2 -> SearchScreen(navigateToDetails = onClickCallback, backToHome = {
                scope.launch {
                    pagerState.animateScrollToPage(0)
                }
            })
            3 -> Text(text = "Add")
            4 -> Text(text = "Profile")
        }
    }
}