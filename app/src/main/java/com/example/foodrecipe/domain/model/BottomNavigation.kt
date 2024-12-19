package com.example.foodrecipe.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val contentDescription: String,
    val label: String,
)