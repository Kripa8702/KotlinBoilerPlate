package com.boilerplate.kotlin.presentation.screens.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.boilerplate.kotlin.navigation.NavigationItem
import com.boilerplate.kotlin.presentation.screens.main.first_tab.composable_usages.ComposableUsagesScreen
import com.boilerplate.kotlin.presentation.screens.main.first_tab.heirarchy.HierarchyScreen
import com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages.ViewModelUsagesScreen
import com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages.ViewModelUsagesViewModel
import com.boilerplate.kotlin.utils.NavigationHelper

@Composable
fun BottomNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val viewModelUsagesViewModel = hiltViewModel<ViewModelUsagesViewModel>()

    NavHost(
        navController = navController,
        startDestination = NavigationItem.FirstTab.route
    ) {
        firstTabGraph(navController)

        composable(
            route = NavigationItem.ViewModelUsages.route,
            enterTransition = { NavigationHelper.enterTransition() },
            exitTransition = { NavigationHelper.exitTransition() }
        ) {
            ViewModelUsagesScreen(
                navController = navController,
                viewModel = viewModelUsagesViewModel
            )
        }
    }
}


fun NavGraphBuilder.firstTabGraph(navController: NavHostController) {
    navigation(
        route = NavigationItem.FirstTab.route,
        startDestination = NavigationItem.Hierarchy.route
    ) {
        composable(
            route = NavigationItem.Hierarchy.route,
            enterTransition = { NavigationHelper.enterTransition() },
            exitTransition = { NavigationHelper.exitTransition() }
        ) {
            HierarchyScreen(
                navController = navController
            )
        }

        composable(
            route = NavigationItem.ComposableUsages.route,
            enterTransition = { NavigationHelper.enterTransition() },
            exitTransition = { NavigationHelper.exitTransition() }
        ) {
            ComposableUsagesScreen(
                navController = navController
            )
        }
    }
}