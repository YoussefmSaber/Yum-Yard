package com.example.foodrecipe.presentation.componants

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentation.componants.buttons.BackArrowButton
import com.example.foodrecipe.presentation.componants.buttons.ShareButton
import com.example.foodrecipe.presentation.componants.buttons.auth.LogoutButton
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.Transparent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralTopBar(
    title: String,
    isNavigationIcon: Boolean = false,
    isShareIcon: Boolean = false,
    isLogoutIcon: Boolean = false,
    onCLickCallBack: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarColors(
            scrolledContainerColor = Transparent,
            titleContentColor = Black,
            actionIconContentColor = Primary100,
            containerColor = Transparent,
            navigationIconContentColor = Black
        ),
        title = {
            Text(
                title,
                maxLines = 1,
                fontSize = 25.sp,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (isNavigationIcon) BackArrowButton(
                onClick = onCLickCallBack,
                modifier = Modifier
            )
        },
        actions = {
            if (isShareIcon) {
                ShareButton(onShareClick = {

                })
            }
            if (isLogoutIcon) {
                LogoutButton(onLogoutClickable = {

                })
            }
        }
    )
}

