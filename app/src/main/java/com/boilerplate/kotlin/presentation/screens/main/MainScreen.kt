package com.boilerplate.kotlin.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.boilerplate.kotlin.presentation.composables.CommonText
import com.boilerplate.kotlin.presentation.screens.main.navigation.BottomNavComponent
import com.boilerplate.kotlin.presentation.screens.main.navigation.BottomNavGraph
import com.boilerplate.kotlin.utils.h

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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.h())
            .height(70.h())
            .padding(vertical = 2.h())
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(20.h()),
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
                    navController = navController
                )
            }
        }

    }
}


@Composable
fun BottomBarItem(
    bottomNavComponent: BottomNavComponent,
    navController: NavController
) {
    val currentDestination = navController.currentDestination
    val selected = navController.currentDestination?.hierarchy?.any { it.route == bottomNavComponent.route } == true

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

    Column(
        modifier = Modifier
            .wrapContentWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        if (navController.currentDestination?.route != bottomNavComponent.route) {
                            navController.navigate(bottomNavComponent.route) {
                                launchSingleTop = true
                                popUpTo(currentDestination?.id ?: -1) {
                                    saveState = true
                                    inclusive = true
                                }
                                restoreState = true
                            }
                        }
                    }
                )
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(24.h())
                .padding(bottom = 4.h()),
            painter = painterResource(id = icon),
            contentDescription = bottomNavComponent.name,
            tint = color
        )
        CommonText(
            takeFullWidth = false,
            text = bottomNavComponent.name,
            style = MaterialTheme.typography.labelSmall,
            color = color
        )
    }

}