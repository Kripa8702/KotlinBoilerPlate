package com.boilerplate.kotlin.presentation.screens.dummy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.boilerplate.kotlin.presentation.composables.BaseScreen

@Composable
fun DummyScreen(
    navController: NavController,
    dummyViewModel: DummyViewModel
) {

    BaseScreen {
        // Your screen content here
        Text(
            text = "Dummy Screen",
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}