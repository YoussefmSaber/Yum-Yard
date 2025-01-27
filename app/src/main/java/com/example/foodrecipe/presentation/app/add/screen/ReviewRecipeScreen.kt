package com.example.foodrecipe.presentation.app.add.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodrecipe.domain.model.recipe.AddRecipe
import com.example.foodrecipe.presentation.app.add.view_model.AddRecipeViewModel
import com.example.foodrecipe.presentation.componants.CustomTabs
import com.example.foodrecipe.presentation.componants.GeneralTopBar
import com.example.foodrecipe.presentation.componants.RecipeNewPager
import com.example.foodrecipe.presentation.componants.RecipeReviewImage
import com.example.foodrecipe.presentation.componants.RecipeTitle
import com.example.foodrecipe.presentation.componants.buttons.auth.EmailAuthButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ReviewRecipeScreen(
    onPostClick: () -> Unit,
    onPreviousClick: () -> Unit,
) {
    val viewModel: AddRecipeViewModel = koinViewModel()
    val recipeData by viewModel.recipeData.collectAsState()
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            GeneralTopBar(
                title = "Review the recipe", isNavigationIcon = true,
                onCLickCallBack = onPreviousClick
            )
        }
    ) { innerPadding ->
        ScreenContent(innerPadding, recipeData, pagerState, coroutineScope) {
            viewModel.postRecipe()
            onPostClick()
        }
    }
}

@Composable
private fun ScreenContent(
    innerPadding: PaddingValues,
    recipeData: AddRecipe,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    onPostCallback: () -> Unit,
) {
    ConstraintLayout(Modifier.padding(innerPadding)) {
        val (content, button) = createRefs()
        val horizontalCenterGuideline = createGuidelineFromTop(0.75f)
        Column(modifier = Modifier.constrainAs(content)
        {
            top.linkTo(parent.top)
            start.linkTo(parent.start, margin = 16.dp)
            end.linkTo(parent.end, margin = 16.dp)
            bottom.linkTo(horizontalCenterGuideline)
        })
        {
            RecipeReviewImage("")
            Spacer(Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeTitle(recipeData.name, modifier = Modifier.weight(3f))
                Spacer(Modifier.width(16.dp))
                Text(
                    recipeData.area, fontSize = 16.sp, fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(Modifier.height(16.dp))
            // Custom Tabs
            CustomTabs(selectedTap = { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            })
            Spacer(Modifier.height(8.dp))
            // Horizontal Pager
            RecipeNewPager(pagerState, recipeData)
        }
        Box(Modifier
            .constrainAs(button) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .fillMaxWidth(0.6f)) {
            EmailAuthButton("Post", onClick = onPostCallback)
        }
    }
}