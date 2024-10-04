package com.boilerplate.kotlin.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/** This is for Kiosk applications */

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