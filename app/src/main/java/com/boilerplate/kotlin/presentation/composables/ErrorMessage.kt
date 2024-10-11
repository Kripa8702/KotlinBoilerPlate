package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.utils.h
import com.boilerplate.kotlin.utils.w

@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier,
    message: String,
    onTryAgain: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(horizontal = 16.w()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.error_icon),
            contentDescription = "Error",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier
                .height(50.h())
        )
        Spacer(modifier = Modifier.height(20.h()))
        CommonText(
            text = "Oops!",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            contentAlignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(10.h()))

        CommonText(
            text = message,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            textAlign = TextAlign.Center,
            contentAlignment = Alignment.Center
        )
        if (onTryAgain != null) {
            CommonButton(
                modifier = Modifier
                    .width(200.w())
                    .padding(top = 20.h()),
                fillColor = MaterialTheme.colorScheme.error,
                text = "Try Again",
                onClick = { onTryAgain() }
            )
        }
    }
}

@Preview
@Composable
fun ErrorMessagePreview() {
    ErrorMessage(
        message = "Something went wrong!",
        onTryAgain = {}
    )
}