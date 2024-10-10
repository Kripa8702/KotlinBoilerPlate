package com.boilerplate.kotlin.presentation.screens.main.navigation


import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.navigation.NavigationItem

sealed class BottomNavComponent(
    val name: String,
    val route: String,
    val iconSelected: Int,
    val iconUnselected: Int
) {
    data object Hierarchy : BottomNavComponent(
        name = "Hierarchy",
        route = NavigationItem.Hierarchy.route,
        iconSelected = R.drawable.composable_filled,
        iconUnselected = R.drawable.composable_unfilled
    )

    data object ViewModelUsages : BottomNavComponent(
        name = "ViewModel Usages",
        route = NavigationItem.ViewModelUsages.route,
        iconSelected = R.drawable.composable_filled,
        iconUnselected = R.drawable.composable_unfilled
    )
}