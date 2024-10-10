package com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages


sealed class DummyUiState {
    data object Initial : DummyUiState()
    data object Loading : DummyUiState()

    data object Success : DummyUiState()

    data class Error(val message: String) : DummyUiState()
}