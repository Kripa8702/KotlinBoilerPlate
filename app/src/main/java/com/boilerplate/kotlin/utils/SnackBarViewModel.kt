package com.boilerplate.kotlin.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SnackBarViewModel @Inject constructor() : ViewModel() {

    private val _isSuccess = MutableStateFlow(true)
    val isSuccess = _isSuccess

    private val _message = MutableStateFlow("")
    val message = _message

    private val _showSnackBar = MutableStateFlow(false)
    val showSnackBar = _showSnackBar


    fun showSnackBar(
        message: String,
        isSuccess: Boolean = true,
    ) = viewModelScope.launch {
        _message.value = message
        _isSuccess.value = isSuccess
        _showSnackBar.value = true

        delay(3000)
        _showSnackBar.value = false
    }

    fun hideSnackBar() = viewModelScope.launch {
        _showSnackBar.value = false
    }
}