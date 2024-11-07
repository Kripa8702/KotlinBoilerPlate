package com.boilerplate.kotlin.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }

/** use like this :
 * val topBottomFade = Brush.verticalGradient(
 *   0f to MaterialTheme.colorScheme.surfaceBright.copy(alpha = 0f),
 *   0.05f to MaterialTheme.colorScheme.surfaceBright,
 *   0.95f to MaterialTheme.colorScheme.surfaceBright,
 *   1f to MaterialTheme.colorScheme.surfaceBright.copy(alpha = 0f)
 *       )
 *
 *    val topFade = Brush.verticalGradient(0f to Color.Transparent, 0.3f to Color.Red)
 *         Box(modifier = Modifier.fadingEdge(topFade).background(Color.Blue).size(100.dp))
 *
 *  Refer this link for more details : https://stackoverflow.com/questions/66762472/how-to-add-fading-edge-effect-to-android-jetpack-compose-column-or-row
 */