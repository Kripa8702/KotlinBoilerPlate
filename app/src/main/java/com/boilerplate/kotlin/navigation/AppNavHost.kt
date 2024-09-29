package com.boilerplate.kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boilerplate.kotlin.presentation.screens.dummy.DummyScreen
import com.boilerplate.kotlin.presentation.screens.dummy.DummyViewModel
import com.boilerplate.kotlin.utils.NavigationHelper

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    // Hilt view models
    val dummyViewModel = hiltViewModel<DummyViewModel>()

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Dummy.route
    ) {
        composable(
            route = NavigationItem.Dummy.route,
            enterTransition = { NavigationHelper.enterTransition() },
            exitTransition = { NavigationHelper.exitTransition() }
        ) {
            DummyScreen(
                navController = navController,
                dummyViewModel = dummyViewModel
            )
        }

        // Navigation with Arguments
//        composable(
//            route = NavigationItem.EventDetails.route + "/{eventId}",
//            arguments = listOf(navArgument("eventId") { type = NavType.IntType }),
//            enterTransition = { NavigationHelper.enterTransition() },
//            exitTransition = { NavigationHelper.exitTransition() }
//        ) { backStackEntry ->
//            val eventId = backStackEntry.arguments?.getInt("eventId")
//            EventDetailsScreen(
//                navController = navController,
//                eventId = eventId ?: 0,
//                eventsViewModel = eventsViewModel,
//                topBarViewModel = topBarViewModel
//            )
//        }

    }
}