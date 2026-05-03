package com.IngesPous.minitec.di

import com.IngesPous.minitec.data.repository.dataSource.AuthRemoteDataSource
import com.IngesPous.minitec.data.repository.AuthRepositoryImpl
import com.IngesPous.minitec.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository = AuthRepositoryImpl(authRemoteDataSource);


}