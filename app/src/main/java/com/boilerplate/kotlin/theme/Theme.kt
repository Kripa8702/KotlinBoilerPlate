package com.boilerplate.kotlin.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.boilerplate.kotlin.theme.DarkBackground
import com.boilerplate.kotlin.theme.DarkOnSurface
import com.boilerplate.kotlin.theme.DarkPrimary
import com.boilerplate.kotlin.theme.DarkSecondary
import com.boilerplate.kotlin.theme.DarkSurface
import com.boilerplate.kotlin.theme.DarkTertiary
import com.boilerplate.kotlin.theme.LightBackground
import com.boilerplate.kotlin.theme.LightOnSurface
import com.boilerplate.kotlin.theme.LightPrimary
import com.boilerplate.kotlin.theme.LightSecondary
import com.boilerplate.kotlin.theme.LightSurface
import com.boilerplate.kotlin.theme.LightTertiary

private val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    primary = DarkPrimary,
    secondary = DarkSecondary,
    tertiary = DarkTertiary
)

private val LightColorScheme = lightColorScheme(
    background = LightBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    primary = LightPrimary,
    secondary = LightSecondary,
    tertiary = LightTertiary
)

@Composable
fun KotlinBoilerPlateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}