package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun CommonImage(
    modifier: Modifier,
    imageUrl: String,
    contentDescription: String,
    radius: Dp = 12.dp
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        loading = {
            Loader()
        },
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(radius))
    )
}