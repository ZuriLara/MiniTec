package com.IngesPous.minitec.data.repository.dataSource

import com.IngesPous.minitec.domain.model.AuthResponse
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Response<AuthResponse>;
}