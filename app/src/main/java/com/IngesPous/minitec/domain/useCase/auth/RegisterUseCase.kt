package com.IngesPous.minitec.domain.useCase.auth

import com.IngesPous.minitec.domain.model.User
import com.IngesPous.minitec.domain.repository.AuthRepository
import com.IngesPous.minitec.domain.util.Resource

data class RegisterUseCase(private val repository: AuthRepository){
    suspend operator fun invoke(user: User)= repository.register(user);
}
