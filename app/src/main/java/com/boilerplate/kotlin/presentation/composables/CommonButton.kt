package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.boilerplate.kotlin.theme.White
import com.boilerplate.kotlin.utils.h

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isFilled: Boolean = true,
    fillColor: Color? = null,
    enabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.labelMedium.copy(
        fontWeight = FontWeight.SemiBold
    ),
    height: Dp = 50.h(),
    radius: Dp = 10.h()
) {

    val filledContentColor = White
    val unfilledContentColor = MaterialTheme.colorScheme.primary

    val fillContainerColor = fillColor ?: MaterialTheme.colorScheme.primary
    val unfilledContainerColor = MaterialTheme.colorScheme.background

    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(radius),
        border = if (!isFilled) BorderStroke(
            2.h(),
            MaterialTheme.colorScheme.primary
        ) else null,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (isFilled) fillContainerColor else unfilledContainerColor,
            contentColor = if (isFilled) filledContentColor else unfilledContentColor,
            disabledContainerColor = if (isFilled) fillContainerColor.copy(alpha = 0.7f) else unfilledContainerColor.copy(alpha = 0.7f),
            disabledContentColor = if (isFilled) filledContentColor.copy(alpha = 0.6f) else unfilledContentColor.copy(alpha = 0.6f),
        ),
        onClick = { onClick() },
    ) {
        if (enabled)
            CommonText(
                text = text,
                style = textStyle,
                color = if (isFilled) filledContentColor else unfilledContentColor,
                textAlign = TextAlign.Center,
                contentAlignment = Alignment.Center,
            )
        else
            Loader(
                size = 20,
                color = if (isFilled) filledContentColor.copy(alpha = 0.6f) else unfilledContentColor.copy(alpha = 0.6f),
            )
    }
}

@Preview
@Composable
fun CommonButtonPreview() {
    CommonButton(
        text = "Add",
        onClick = { },
        isFilled = false,
        enabled = false
    )
}