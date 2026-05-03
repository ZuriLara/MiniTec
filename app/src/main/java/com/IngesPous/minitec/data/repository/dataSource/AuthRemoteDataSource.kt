package com.IngesPous.minitec.data.repository.dataSource

import com.IngesPous.minitec.domain.model.AuthResponse
import com.IngesPous.minitec.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Response<AuthResponse>;
    suspend fun register(user: User): Response<AuthResponse>;
}