package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boilerplate.kotlin.utils.h

@Composable
fun CommonContainer(
    modifier: Modifier = Modifier,
    radius: Dp = 12.h(),
    paddingValues: PaddingValues = PaddingValues(16.dp),
    contentAlignment: Alignment = Alignment.TopStart,
    color: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = color,
                shape = RoundedCornerShape(radius)
            )
            .padding(paddingValues),
        contentAlignment = contentAlignment,
    ) {
        content()
    }
}