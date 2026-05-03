package com.IngesPous.minitec.data.repository

import com.IngesPous.minitec.data.repository.dataSource.AuthRemoteDataSource
import com.IngesPous.minitec.domain.model.AuthResponse

import com.IngesPous.minitec.domain.repository.AuthRepository
import com.IngesPous.minitec.domain.util.Resource


class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            val body = result.body()

            if (result.isSuccessful && body != null) {
                Resource.Success(body)
            } else {
                Resource.Failure(Exception("Error en la respuesta: ${result.code()}"))
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}