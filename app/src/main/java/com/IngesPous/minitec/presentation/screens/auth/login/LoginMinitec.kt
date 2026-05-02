package com.IngesPous.minitec.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.IngesPous.minitec.core.Config
import com.IngesPous.minitec.data.service.AuthService
import com.IngesPous.minitec.domain.model.LoginRequest
import com.IngesPous.minitec.presentation.screens.auth.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class LoginMinitec @Inject constructor(): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set
    //var email by mutableStateOf("")
    //var password by mutableStateOf("")

    var errorMessage by mutableStateOf("")
        private set



    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            val authService = retrofit.create(AuthService::class.java)
            val result = authService.login(LoginRequest(state.email, state.password))
            Log.d("LoginMiniTec", "Result: ${result.body()}");

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
