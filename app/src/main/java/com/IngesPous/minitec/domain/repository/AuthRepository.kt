package com.IngesPous.minitec.domain.repository

import com.IngesPous.minitec.domain.model.AuthResponse
import com.IngesPous.minitec.domain.model.User
import com.IngesPous.minitec.domain.util.Resource


interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>;

    suspend fun register(user: User): Resource<AuthResponse>;
}