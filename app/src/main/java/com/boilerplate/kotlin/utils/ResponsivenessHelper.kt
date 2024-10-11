package com.boilerplate.kotlin.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

/** This is for Mobile applications
 * Use like this: 16.h() or 16.w()
 */

@Composable
fun Int.h(): Dp {
    val figmaHeight = 812 // Replace this with the height of the figma design

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    return (this * screenHeight / figmaHeight)
}

@Composable
fun Double.h(): Dp {
    val figmaHeight = 812 // Replace this with the height of the figma design

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    return (this * screenHeight / figmaHeight)
}

@Composable
fun Int.w(): Dp {
    val figmaWidth = 360 // Replace this with the width of the figma design

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    return (this * screenWidth / figmaWidth)
}

@Composable
fun Double.w(): Dp {
    val figmaWidth = 360 // Replace this with the width of the figma design

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    return (this * screenWidth / figmaWidth)
}


/** This is for Kiosk applications
 * Use like this: 16.dp.responsive()
 */

@Composable
fun Dp.responsive(): Dp {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    return when {
        screenHeight < 850.dp -> this // mobile
        else -> this * 2.5f // kiosk
    }
}

@Composable
fun TextUnit.responsiveText(): TextUnit {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    return when {
        screenHeight < 850.dp -> this // mobile
        else -> this * 2.5f // kiosk
    }
}