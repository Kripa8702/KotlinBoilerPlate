package com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages


sealed class ViewModelUsagesUiState {
    data object Initial : ViewModelUsagesUiState()
    data object Loading : ViewModelUsagesUiState()

    data object Success : ViewModelUsagesUiState()

    data class Error(val message: String) : ViewModelUsagesUiState()
}