package com.boilerplate.kotlin.presentation.screens.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boilerplate.kotlin.repositories.network.DummyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DummyViewModel @Inject constructor(
    private val dummyRepository: DummyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DummyUiState>(DummyUiState.Initial)
    val uiState = _uiState

    fun fetchDummy(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _uiState.value = DummyUiState.Loading

        try {

            val data = dummyRepository.fetchDummy(email, password)
            _uiState.value = DummyUiState.Success(data)

        } catch (e: Exception) {

            _uiState.value = DummyUiState.Error(e.message ?: "An error occurred")

        }
    }
}