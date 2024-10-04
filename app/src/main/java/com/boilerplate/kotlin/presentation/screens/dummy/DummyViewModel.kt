package com.boilerplate.kotlin.presentation.screens.dummy

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boilerplate.kotlin.repositories.network.DummyRepository
import com.boilerplate.kotlin.repositories.room.DummyRoomRepository
import com.boilerplate.kotlin.room.dummy.Dummy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DummyViewModel @Inject constructor(
    private val dummyRepository: DummyRepository,
    private val dummyRoomRepository: DummyRoomRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DummyUiState>(DummyUiState.Initial)
    val uiState = _uiState

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn


    /** Network Calls */
    fun fetchDummyFromNetwork(
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

    /** Room Calls */
    fun fetchDummyFromRoom() = viewModelScope.launch {
        try {
            val data = dummyRoomRepository.getDummy()

            if (data != null) {
                _isLoggedIn.value = data.isLoggedIn
            }

        } catch (e: Exception) {
            Log.e("DummyViewModel", "Failed to fetch Dummy from Room: ${e.message}")
        }
    }

    fun insertDummyToRoom(
        isLoggedIn: Boolean
    ) = viewModelScope.launch {
        try {
            val dummy = Dummy(
                isLoggedIn = isLoggedIn
            )

            dummyRoomRepository.insertDummy(dummy)
        } catch (e: Exception) {
            Log.e("DummyViewModel", "Failed to insert Dummy to Room: ${e.message}")
        }
    }

    fun clearDummyFromRoom() = viewModelScope.launch {
        try {
            dummyRoomRepository.clearDummy()
        } catch (e: Exception) {
            Log.e("DummyViewModel", "Failed to clear Dummy from Room: ${e.message}")
        }
    }
}