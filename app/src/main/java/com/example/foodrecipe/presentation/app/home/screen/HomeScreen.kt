package com.example.foodrecipe.presentation.app.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Bookmark-fill`
import com.example.foodrecipe.common.assets.icons.`Bookmark-outline`
import com.example.foodrecipe.common.assets.icons.`Home-fill`
import com.example.foodrecipe.common.assets.icons.`Home-outline`
import com.example.foodrecipe.common.assets.icons.`Plus-fill`
import com.example.foodrecipe.common.assets.icons.`Plus-outline`
import com.example.foodrecipe.common.assets.icons.Profile
import com.example.foodrecipe.common.assets.icons.`Profile-fill`
import com.example.foodrecipe.common.assets.icons.`Search-fill`
import com.example.foodrecipe.common.assets.icons.`Search-outline`
import com.example.foodrecipe.presentation.app.search.screen.SearchScreen
import com.example.foodrecipe.ui.theme.White
import com.example.foodrecipe.ui.theme.navigationBarItemColors
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeScreen(onClickCallback: (String) -> Unit) {
    val selectedItem = remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { 5 }, initialPage = 0)
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            NavigationBar(containerColor = White, tonalElevation = 5.dp) {
                BottomNavigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem.intValue == index,
                        icon = {
                            Icon(
                                imageVector = if (selectedItem.intValue == index) item.selectedIcon
                                else item.unselectedIcon,
                                contentDescription = item.label,
                            )
                        },
                        onClick = {
                            selectedItem.intValue = index
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        label = {
                            Text(item.label)
                        },
                        alwaysShowLabel = false,
                        colors = navigationBarItemColors
                    )

                }
            }
        }
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding,
            userScrollEnabled = false,
        ) { page ->
            when (page) {
                0 -> Text(text = "Home")

                1 -> Text(text = "Saved")

                2 -> Text(text = "Add")

                3 -> SearchScreen(navigateToDetails = onClickCallback, backToHome = {
                    scope.launch {
                        selectedItem.intValue = 0
                        pagerState.animateScrollToPage(0)
                    }
                })

                4 -> Text(text = "Profile")
            }
        }
    }
}

data class BottomNavigationItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val contentDescription: String,
    val label: String,
)

val BottomNavigationItems = listOf(
    BottomNavigationItem(Iconly.`Home-fill`, Iconly.`Home-outline`, "Home", "Home"),
    BottomNavigationItem(Iconly.`Bookmark-fill`, Iconly.`Bookmark-outline`, "Saved", "Saved"),
    BottomNavigationItem(Iconly.`Plus-fill`, Iconly.`Plus-outline`, "Add", "Add"),
    BottomNavigationItem(Iconly.`Search-fill`, Iconly.`Search-outline`, "Search", "Search"),
    BottomNavigationItem(Iconly.`Profile-fill`, Iconly.Profile, "Profile", "Profile")
)
