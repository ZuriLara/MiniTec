package com.IngesPous.minitec.data.repository


import com.IngesPous.minitec.data.repository.dataSource.AuthRemoteDataSource
import com.IngesPous.minitec.domain.model.AuthResponse
import com.IngesPous.minitec.domain.model.User
import com.IngesPous.minitec.domain.repository.AuthRepository
import com.IngesPous.minitec.domain.util.Resource
import com.IngesPous.minitec.domain.util.ResponseToRequest



class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(authRemoteDataSource.register(user))

}