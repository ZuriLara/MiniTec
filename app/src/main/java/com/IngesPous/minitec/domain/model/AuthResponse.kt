package com.IngesPous.minitec.domain.model

data class AuthResponse(
    val user: User,
    val token: String
)
