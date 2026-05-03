package com.IngesPous.minitec.di

import com.IngesPous.minitec.domain.repository.AuthRepository
import com.IngesPous.minitec.domain.useCase.auth.AuthUseCase
import com.IngesPous.minitec.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(login = LoginUseCase(authRepository));

}