package com.boilerplate.kotlin.presentation.screens.main.first_tab.composable_usages

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.boilerplate.kotlin.presentation.composables.BaseScreen
import com.boilerplate.kotlin.presentation.composables.CommonButton
import com.boilerplate.kotlin.presentation.composables.CommonContainer
import com.boilerplate.kotlin.presentation.composables.CommonImage
import com.boilerplate.kotlin.presentation.composables.CommonText
import com.boilerplate.kotlin.presentation.composables.CommonTextField
import com.boilerplate.kotlin.utils.SnackBarViewModel
import com.boilerplate.kotlin.utils.responsive

@Composable
fun ComposableUsagesScreen(
    navController: NavController
) {
    val snackBarViewModel = hiltViewModel<SnackBarViewModel>()

    val textField = remember {
        mutableStateOf(TextFieldValue())
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    BaseScreen {
        Column {
            CommonText(
                text = "Composable Usages",
                style = MaterialTheme.typography.titleMedium,
                contentAlignment = Alignment.CenterStart,
            )

            Spacer(modifier = Modifier.height(25.dp.responsive()))

            CommonTextField(
                textFieldValue = textField,
                hintText = "Search here...",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colorScheme.outline
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        Log.d("DummyScreen", "Search clicked")
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                )
            )

            Spacer(modifier = Modifier.height(16.dp.responsive()))

            CommonContainer(
                color = MaterialTheme.colorScheme.secondary,
            ) {
                CommonText(
                    text = "This is a dummy container",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }

            Spacer(modifier = Modifier.height(16.dp.responsive()))

            CommonImage(
                modifier = Modifier.height(200.dp.responsive()),
                imageUrl = "https://picsum.photos/200/300",
                contentDescription = "This is a dummy image",
            )

            Spacer(modifier = Modifier.height(30.dp.responsive()))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CommonButton(
                    modifier = Modifier.weight(0.5f),
                    text = "Dismiss",
                    isFilled = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(16.dp.responsive()))
                CommonButton(
                    modifier = Modifier.weight(0.5f),
                    text = "Show Snack Bar",
                    onClick = {
                        snackBarViewModel.showSnackBar(
                            message = "This is a dummy snack bar",
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp.responsive()))
        }
    }
}