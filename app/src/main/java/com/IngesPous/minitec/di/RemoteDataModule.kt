package com.IngesPous.minitec.di

import com.IngesPous.minitec.data.repository.dataSource.AuthRemoteDataSource
import com.IngesPous.minitec.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.IngesPous.minitec.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService);

}