package com.boilerplate.kotlin.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/** This is for Kiosk applications */

@Composable
fun Dp.toResponsive(): Dp {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    return when {
        screenHeight < 850.dp -> this * 0.8f // mobile
        screenHeight < 1300.dp -> this // tablet
        else -> this * 2f // kiosk
    }
}

@Composable
fun TextUnit.toResponsiveText(): TextUnit {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    return when {
        screenHeight < 850.dp -> this * 0.8f // mobile
        screenHeight < 1300.dp -> this // tablet
        else -> this * 2f // kiosk
    }
}