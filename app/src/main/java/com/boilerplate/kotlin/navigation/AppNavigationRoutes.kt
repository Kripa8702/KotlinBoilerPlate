package com.boilerplate.kotlin.navigation

enum class Screen {
    DUMMY
}
sealed class NavigationItem(val route: String) {
    data object Dummy : NavigationItem(Screen.DUMMY.name)
}