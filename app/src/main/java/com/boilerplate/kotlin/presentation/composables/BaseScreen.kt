package com.boilerplate.kotlin.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.boilerplate.kotlin.utils.SnackBarViewModel
import com.boilerplate.kotlin.utils.h
import com.boilerplate.kotlin.utils.w

@Composable
fun BaseScreen(
    title: String = "",
    paddingValues: PaddingValues = PaddingValues(vertical = 8.h(), horizontal = 16.w()),
    content: @Composable () -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    // SnackBar
    val snackBarViewModel = hiltViewModel<SnackBarViewModel>()

    val showSnackBar by snackBarViewModel.showSnackBar.collectAsState()
    val snackBarMessage by snackBarViewModel.message.collectAsState()
    val isSuccessSnackBar by snackBarViewModel.isSuccess.collectAsState()


    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(paddingValues)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }
                )
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column {
                if (title.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .padding(top = 25.h(), bottom = 16.h())
                            .fillMaxWidth()
                    ) {
                        CommonText(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .imePadding()
                ) {
                    content()
                }
            }
            CustomSnackBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                isSuccess = isSuccessSnackBar,
                visible = showSnackBar,
                message = snackBarMessage,
                onDismiss = {
                    snackBarViewModel.hideSnackBar()
                }
            )
        }
    }
}