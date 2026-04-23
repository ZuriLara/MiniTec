package com.IngesPous.minitec.presentation.screens.auth.register

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
//11:53
    var state by mutableStateOf(RegisterState())

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }
    fun onLastnameInput(input: String) {
        state = state.copy(lastname = input)
    }
    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }
    fun onMatriculateInput(input: String) {
        state = state.copy(matriculate = input)
    }
    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }
    fun onConfirmPasswordInput(input: String) {
        state = state.copy(confirmPassword = input)
    }
}