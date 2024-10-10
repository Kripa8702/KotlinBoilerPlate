package com.boilerplate.kotlin.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.boilerplate.kotlin.presentation.screens.main.navigation.BottomNavComponent
import com.boilerplate.kotlin.presentation.screens.main.navigation.BottomNavGraph
import com.boilerplate.kotlin.utils.responsive

val screens = listOf(
    BottomNavComponent.Hierarchy,
    BottomNavComponent.ViewModelUsages,
)

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    val showBottomBar = currentDestination?.route in screens.map { it.route }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        bottomBar = {
            if (showBottomBar)
                BottomNavigationBar(
                    navController = navController
                )
        }
    ) {
        BottomNavGraph(
            navController = navController,
            modifier = Modifier
                .padding(it)
        )
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp.responsive())
            .height(60.dp.responsive())
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(20.dp.responsive()),
            )
            .clipToBounds()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            screens.forEach { bottomNavComponent ->
                BottomBarItem(
                    bottomNavComponent = bottomNavComponent,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }

    }
}


@Composable
fun BottomBarItem(
    bottomNavComponent: BottomNavComponent,
    currentDestination: NavDestination?,
    navController: NavController
) {
    val selected =
        currentDestination?.hierarchy?.any { it.route == bottomNavComponent.route } == true

    val icon = if (selected) {
        bottomNavComponent.iconSelected
    } else {
        bottomNavComponent.iconUnselected
    }

    val color = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Box(
        modifier = Modifier
            .padding(10.dp.responsive())
            .size(50.dp.responsive())
    ) {
        IconButton(
            onClick = {
                navController.navigate(bottomNavComponent.route) {
                    launchSingleTop = true
                    popUpTo(currentDestination?.id ?: -1) {
                        saveState = true
                        inclusive = true
                    }
                    restoreState = true
                }
            }
        ) {
            Icon(
                modifier = Modifier
                    .padding(8.dp.responsive()),
                painter = painterResource(id = icon),
                contentDescription = bottomNavComponent.name,
                tint = color
            )
        }
    }

}