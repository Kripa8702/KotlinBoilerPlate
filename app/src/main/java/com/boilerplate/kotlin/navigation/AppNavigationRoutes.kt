package com.boilerplate.kotlin.navigation

enum class Screen {
    MAIN,
    FIRST_TAB,
    COMPOSABLE_USAGES,
    HIERARCHY,
    VIEW_MODEL_USAGES,
}
sealed class NavigationItem(val route: String) {
    data object Main : NavigationItem(Screen.MAIN.name)

    // ------- First Tab Navigation Items -------
    data object FirstTab : NavigationItem(Screen.FIRST_TAB.name)
    data object ComposableUsages : NavigationItem(Screen.COMPOSABLE_USAGES.name)
    data object Hierarchy : NavigationItem(Screen.HIERARCHY.name)

    // ------- Second Tab Navigation Items -------
    data object ViewModelUsages : NavigationItem(Screen.VIEW_MODEL_USAGES.name)
}