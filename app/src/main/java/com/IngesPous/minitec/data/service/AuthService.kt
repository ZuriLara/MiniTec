package com.IngesPous.minitec.data.service


import com.IngesPous.minitec.domain.model.AuthResponse
import com.IngesPous.minitec.domain.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    //@FormUrlEncoded
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>
}