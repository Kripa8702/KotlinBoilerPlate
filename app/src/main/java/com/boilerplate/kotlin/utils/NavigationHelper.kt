package com.boilerplate.kotlin.utils

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import com.boilerplate.kotlin.navigation.NavigationItem

class NavigationHelper(
    private val navController: NavController
) {
    fun navigateTo(
        screen: NavigationItem,
        args: String? = null
    ) {
        if (args != null) {
            navController.navigate("${screen.route}/$args")
        } else {
            navController.navigate(screen.route)
        }
    }

    companion object {
        fun enterTransition(): EnterTransition {
            return fadeIn(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }

        fun exitTransition(): ExitTransition {
            return fadeOut(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }
}