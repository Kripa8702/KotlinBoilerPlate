package com.boilerplate.kotlin.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.theme.ErrorColor
import com.boilerplate.kotlin.theme.Grey
import com.boilerplate.kotlin.theme.SuccessColor
import com.boilerplate.kotlin.theme.White
import com.boilerplate.kotlin.utils.h
import com.boilerplate.kotlin.utils.w

@Composable
fun CustomSnackBar(
    isSuccess: Boolean = true,
    message: String,
    modifier: Modifier,
    visible: Boolean,
    onDismiss: () -> Unit = {}
) {
    AnimatedVisibility(
        modifier = modifier
            .padding(
                bottom = 20.h(),
            )
            .border(
                color = Color.Transparent,
                width = 0.dp,
            )
            .height(35.dp),

        visible = visible,
        enter = scaleIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
            )
        ),
        exit = scaleOut(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
            )
        )

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(
                    elevation = 2.h(),
                    spotColor = Grey,
                    ambientColor = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.h())
                )
                .background(
                    color = if (isSuccess) SuccessColor else ErrorColor,
                    shape = RoundedCornerShape(8.h())
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.w())
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = if (isSuccess) R.drawable.success_icon else R.drawable.error_icon),
                        tint = White,
                        contentDescription = "Status",
                        modifier = Modifier
                            .size(16.h())
                    )
                    Spacer(modifier = Modifier.width(10.w()))
                    Text(
                        text = message,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = White
                    )
                }
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear",
                    tint = White.copy(alpha = 0.75f),
                    modifier = Modifier
                        .padding(4.h())
                        .size(22.h())
                        .clickable {
                            onDismiss()
                        }
                )
            }
        }
    }
}