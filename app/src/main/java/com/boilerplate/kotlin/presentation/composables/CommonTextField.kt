package com.boilerplate.kotlin.presentation.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.utils.h
import com.boilerplate.kotlin.utils.responsiveText
import com.boilerplate.kotlin.utils.w

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<TextFieldValue>,
    textStyle: TextStyle = MaterialTheme.typography.labelMedium,
    isPassword: Boolean = false,
    onValueChange: (TextFieldValue) -> Unit = {},
    hintText: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    leadingIcon: @Composable (() -> Unit)? = null,


    /// These values will be passed like : CommonTextField(errorText = "Please enter a valid email", isError = < your check > )
    errorText: String = "",
    isError: Boolean = false,
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isFocused = interactionSource.collectIsFocusedAsState()


    val isVisible = remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        BasicTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(50.h())
                .fillMaxHeight(),
            value = textFieldValue.value,
            onValueChange = {
                textFieldValue.value = it
                onValueChange(it)
            },
            textStyle = textStyle.copy(
                fontSize = textStyle.fontSize.responsiveText(),
                color = if (interactionSource.collectIsFocusedAsState().value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            ),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            interactionSource = interactionSource,
            maxLines = 1,
            singleLine = true,
            visualTransformation = if (!isPassword || isVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        ) { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = textFieldValue.value.text,
                interactionSource = interactionSource,
                innerTextField = innerTextField,
                enabled = true,
                visualTransformation = VisualTransformation.None,
                singleLine = true,
                contentPadding = if (leadingIcon == null) PaddingValues(horizontal = 18.w()) else PaddingValues(
                    end = 18.w()
                ),
                placeholder = {
                    CommonText(
                        text = hintText,
                        style = MaterialTheme.typography.labelMedium,
                        contentAlignment = Alignment.CenterStart,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                    )
                },
                trailingIcon = {
                    val description = if (isVisible.value) "Hide password" else "Show password"
                    val image = if (isVisible.value)
                        R.drawable.visibility_on
                    else R.drawable.visibility_off

                    if (isPassword) {
                        IconButton(
                            modifier = Modifier
                                .padding(horizontal = 10.w())
                                .fillMaxHeight(),
                            onClick = { isVisible.value = !isVisible.value }) {
                            Icon(
                                modifier = Modifier.size(24.h()),
                                painter = painterResource(id = image),
                                tint = if (isFocused.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary.copy(
                                    alpha = 0.4f
                                ),
                                contentDescription = description
                            )
                        }
                    }
                },
                leadingIcon = if (leadingIcon != null) {
                    {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.w())
                                .fillMaxHeight()
                                .width(28.w()),
                            contentAlignment = Alignment.Center

                        ) {
                            leadingIcon()
                        }
                    }
                } else {
                    null
                },
                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled = true,
                        interactionSource = interactionSource,
                        isError = isError,
                        shape = RoundedCornerShape(8.h()),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                            focusedTextColor = MaterialTheme.colorScheme.primary,
                            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                            cursorColor = MaterialTheme.colorScheme.primary,
                            errorBorderColor = MaterialTheme.colorScheme.error,
                        ),
                    )
                }
            )
        }



        if (isError) {
            Text(
                text = errorText,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 10.h())
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun CommonTextFieldPreview() {
    CommonTextField(
        textFieldValue = mutableStateOf(TextFieldValue("")),
        hintText = "Enter your email",
        isError = false,
        errorText = "* Please enter a valid email"
    )
}