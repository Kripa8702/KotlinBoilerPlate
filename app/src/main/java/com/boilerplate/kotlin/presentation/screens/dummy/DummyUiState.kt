package com.boilerplate.kotlin.presentation.screens.dummy

import com.boilerplate.kotlin.models.response.DummyData

sealed class DummyUiState {
    data object Initial : DummyUiState()
    data object Loading : DummyUiState()

    // In case of room data, handle success data in view model and not in UI state
    data class Success(val data: DummyData) : DummyUiState()

    data class Error(val message: String) : DummyUiState()
}