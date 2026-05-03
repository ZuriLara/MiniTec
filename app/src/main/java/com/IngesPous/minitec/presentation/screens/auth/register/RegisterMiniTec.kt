package com.IngesPous.minitec.presentation.screens.auth.register

import android.content.res.Resources
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.IngesPous.minitec.domain.model.AuthResponse
import com.IngesPous.minitec.domain.model.User
import com.IngesPous.minitec.domain.useCase.auth.AuthUseCase
import com.IngesPous.minitec.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterMiniTec @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {
//11:53
    var state by mutableStateOf(RegisterState())
    private set
    var errorMessage by mutableStateOf("")
    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
    private set

    fun register () = viewModelScope.launch {
        if (isvalidateForm()){
            val user= User(
                name = state.name,
                lastname = state.lastname,
                email = state.email,
                password= state.password,
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result

        }

    }


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

    fun isvalidateForm(): Boolean {

        if (state.name==""){
            errorMessage = "Ingrese el nombre"
            return false
        }
        else if (state.lastname==""){
            errorMessage = "Ingrese el apellido"
            return false
        }
        else if(state.email==""){
            errorMessage = "Ingrese el email"
            return false
        }
        else if (state.matriculate==""){
            errorMessage = "Ingrese la matricula"
        }
        else if (state.password==""){
            errorMessage = "Ingrese la contraseña"
            return false
        }
        else if (state.confirmPassword==""){
            errorMessage = "Confirme la contraseña"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
            return false
        }
        return true

    }
}