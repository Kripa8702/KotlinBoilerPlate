package com.boilerplate.kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boilerplate.kotlin.presentation.screens.main.MainScreen
import com.boilerplate.kotlin.utils.NavigationHelper

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Main.route
    ) {
        composable(
            route = NavigationItem.Main.route,
            enterTransition = { NavigationHelper.enterTransition() },
            exitTransition = { NavigationHelper.exitTransition() }
        ) {
            MainScreen()
        }

        // Navigation with Arguments
//        composable(
//            route = NavigationItem.Main.route + "/{eventId}",
//            arguments = listOf(navArgument("eventId") { type = NavType.IntType }),
//            enterTransition = { NavigationHelper.enterTransition() },
//            exitTransition = { NavigationHelper.exitTransition() }
//        ) { backStackEntry ->
//            val eventId = backStackEntry.arguments?.getInt("eventId")
//            MainScreen(
//                navController = navController,
//                eventId = eventId ?: 0,
//                eventsViewModel = eventsViewModel,
//                topBarViewModel = topBarViewModel
//            )
//        }

    }
}