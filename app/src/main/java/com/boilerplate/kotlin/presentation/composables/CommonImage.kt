package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.SubcomposeAsyncImage
import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.utils.h

@Composable
fun CommonImage(
    modifier: Modifier,
    imageResourceId: Int = 0,
    imageUrl: String = "",
    isNetworkImage: Boolean = true,
    contentDescription: String,
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(12.h())
) {

    if (isNetworkImage) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            loading = {
                Loader()
            },
            error = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.error_icon),
                        contentDescription = "Error",
                        tint = Color.White
                    )
                }
            },
            modifier = modifier
                .fillMaxSize()
                .clip(roundedCornerShape)
        )
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
                .clip(roundedCornerShape)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = imageResourceId),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
        }
    }
}