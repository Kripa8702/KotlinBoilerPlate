package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boilerplate.kotlin.theme.White
import com.boilerplate.kotlin.utils.responsive

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isFilled: Boolean = true,
    enabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.labelSmall.copy(
        fontWeight = FontWeight.Medium
    ),
    height: Dp = 50.dp.responsive(),
    radius: Dp = 10.dp.responsive()
) {

    val filledContentColor = White
    val unfilledContentColor = MaterialTheme.colorScheme.primary

    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(radius),
        border = if (!isFilled) BorderStroke(
            2.dp.responsive(),
            MaterialTheme.colorScheme.primary
        ) else null,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (isFilled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
            contentColor = if (isFilled) filledContentColor else unfilledContentColor,
            disabledContainerColor =if (isFilled) MaterialTheme.colorScheme.primary.copy(alpha = 0.7f) else MaterialTheme.colorScheme.background.copy(alpha = 0.7f),
            disabledContentColor = if (isFilled)  filledContentColor.copy(alpha = 0.6f) else unfilledContentColor.copy(alpha = 0.6f),
        ),
        onClick = { onClick() },
    ) {
        if (enabled)
            CommonText(
                text = text,
                style = textStyle,
                color = if (isFilled) filledContentColor else unfilledContentColor,
            )
        else
            CircularProgressIndicator(
                modifier = Modifier
                    .size(20.dp.responsive()),
                strokeWidth = 2.dp.responsive(),
                color = if (isFilled)  filledContentColor.copy(alpha = 0.6f) else unfilledContentColor.copy(alpha = 0.6f),
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