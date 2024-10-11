package com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boilerplate.kotlin.models.response.UsersData
import com.boilerplate.kotlin.repositories.network.UsersRepository
import com.boilerplate.kotlin.repositories.room.DummyRoomRepository
import com.boilerplate.kotlin.room.dummy.Dummy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelUsagesViewModel @Inject constructor(
    private val dummyRepository: UsersRepository,
    private val dummyRoomRepository: DummyRoomRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ViewModelUsagesUiState>(ViewModelUsagesUiState.Initial)
    val uiState = _uiState

    private val _users = MutableStateFlow<List<UsersData>>(emptyList())
    val users = _users

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn


    /** Network Calls */
    fun fetchAllUsers(
        limit: Int
    ) = viewModelScope.launch {
        _uiState.value = ViewModelUsagesUiState.Loading

        try {

            val data = dummyRepository.fetchAllUsers(
                limit = limit
            )

            _users.value = data

            _uiState.value = ViewModelUsagesUiState.Success

        } catch (e: Exception) {

            _uiState.value = ViewModelUsagesUiState.Error(e.message ?: "An error occurred")

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