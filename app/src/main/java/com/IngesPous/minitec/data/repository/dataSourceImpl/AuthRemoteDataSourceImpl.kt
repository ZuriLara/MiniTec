package com.IngesPous.minitec.data.repository.dataSourceImpl

import com.IngesPous.minitec.data.repository.dataSource.AuthRemoteDataSource
import com.IngesPous.minitec.data.service.AuthService
import com.IngesPous.minitec.domain.model.LoginRequest
import com.IngesPous.minitec.domain.model.User
import com.IngesPous.minitec.domain.useCase.auth.AuthResponse
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<com.IngesPous.minitec.domain.model.AuthResponse> = authService.register(user)
    }


