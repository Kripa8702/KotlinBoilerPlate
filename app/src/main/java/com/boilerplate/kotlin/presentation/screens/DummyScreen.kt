package com.boilerplate.kotlin.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boilerplate.kotlin.presentation.composables.BaseScreen

@Composable
fun DummyScreen(
    navController: NavController
) {

    BaseScreen {
        // Your screen content here
    }
}

@Preview
@Composable
fun DummyScreenPreview() {
    DummyScreen(navController = rememberNavController())
}