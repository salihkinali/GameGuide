package com.salihkinali.gameguide.di.repository

import com.salihkinali.gameguide.data.source.RemoteDataSource
import com.salihkinali.gameguide.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class GameRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource
}