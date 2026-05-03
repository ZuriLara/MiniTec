package com.IngesPous.minitec.domain.useCase.auth

import com.IngesPous.minitec.domain.repository.AuthRepository

class LoginUseCase (private val repository: AuthRepository){

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password);
}


