package com.IngesPous.minitec.presentation.screens.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.IngesPous.minitec.presentation.screens.auth.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginMinitec @Inject constructor(): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set
    //var email by mutableStateOf("")
    //var password by mutableStateOf("")

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

}