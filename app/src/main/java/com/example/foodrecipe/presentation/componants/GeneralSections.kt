package com.example.foodrecipe.presentation.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.BottomNavigationItems
import com.example.foodrecipe.domain.model.recipe.Meal
import com.example.foodrecipe.presentation.componants.buttons.FilterButton
import com.example.foodrecipe.presentation.componants.buttons.FollowButton
import com.example.foodrecipe.ui.theme.White
import com.example.foodrecipe.ui.theme.navigationBarItemColors

@Composable
fun ChefDetails() {
    val isFollowed = remember { mutableStateOf(false) }
    val animations = animations(isFollowed.value)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChefImage()
            Box(Modifier.width(8.dp))
            ChefNameAndFollowers("Chef Ma7ros", 1000)
        }
        FollowButton(animations, isFollowed)
    }
}

@Composable
fun RecipePager(pagerState: PagerState, recipe: Meal) {
    HorizontalPager(
        state = pagerState,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = false
    ) { page ->
        when (page) {
            0 -> IngredientsList(recipe.recipeIngredients, recipe.recipeMeasures)
            1 -> InstructionsList(recipe.recipeInstructions)
            2 -> CommentsSection()
        }
    }
}

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

@Composable
fun SearchBar(searchQuery: String, onQueryChanged: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
    ) {
        SearchInputField(searchQuery, onQueryChanged)

        FilterButton()
    }
}

@Composable
fun NavBar(selectedItem: Int, changeScreen: (Int) -> Unit) {
    NavigationBar(containerColor = White, tonalElevation = 5.dp) {
        BottomNavigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                icon = {
                    Icon(
                        imageVector = if (selectedItem == index) item.selectedIcon
                        else item.unselectedIcon,
                        contentDescription = item.label,
                    )
                },
                onClick = { changeScreen(index) },
                label = {
                    Text(item.label)
                },
                alwaysShowLabel = false,
                colors = navigationBarItemColors
            )
        }
    }
}