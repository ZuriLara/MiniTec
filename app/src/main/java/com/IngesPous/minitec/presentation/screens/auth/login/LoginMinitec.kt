package com.IngesPous.minitec.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.IngesPous.minitec.domain.model.AuthResponse

import com.IngesPous.minitec.domain.useCase.auth.AuthUseCase
import com.IngesPous.minitec.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginMinitec @Inject constructor(private val AuthUseCase: AuthUseCase): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set
    //var email by mutableStateOf("")
    //var password by mutableStateOf("")

    var errorMessage by mutableStateOf("")
        private set

    var loginResponse by mutableStateOf<Resource< AuthResponse>?>(null);

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginResponse = Resource.Loading;
            val result = AuthUseCase.login(state.email, state.password)
            loginResponse = result;
            Log.d("LoginMiniTec", "Result: ${loginResponse}");

        }
    }

    fun isValidForm(): Boolean {

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false;
        }
        else if (state.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false;
        }
        return true;
    }
}
