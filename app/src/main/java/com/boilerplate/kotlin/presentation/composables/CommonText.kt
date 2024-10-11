package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.boilerplate.kotlin.utils.responsiveText

@Composable
fun CommonText(
    modifier: Modifier = Modifier,
    text: String,
    annotatedString: AnnotatedString? = null,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Start,
    contentAlignment: Alignment = Alignment.CenterStart,
    color: Color = MaterialTheme.colorScheme.onSurface,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    fontStyle: FontStyle = FontStyle.Normal,
    takeFullWidth: Boolean = true
) {
    val fontSize = style.fontSize.responsiveText()

    Box(
        modifier = modifier
            .wrapContentHeight()
            .then(if(takeFullWidth) Modifier.fillMaxWidth() else Modifier),
        contentAlignment = contentAlignment
    ) {
        if(annotatedString != null) {
            Text(
                text = annotatedString,
                style = style.copy(fontSize = fontSize),
                lineHeight = fontSize * 1.2f,
                textAlign = textAlign,
                color = color,
                maxLines = maxLines,
                overflow = overflow,
            )
        } else {
            Text(
                text = text,
                style = style.copy(fontSize = fontSize),
                lineHeight = fontSize * 1.2f,
                textAlign = textAlign,
                color = color,
                maxLines = maxLines,
                overflow = overflow,
                fontStyle = fontStyle
            )
        }
    }
}