package com.salihkinali.data.di.repository

import com.salihkinali.data.repository.GameRepositoryImpl
import com.salihkinali.data.source.RemoteDataSource
import com.salihkinali.data.source.RemoteDataSourceImpl
import com.salihkinali.domain.repository.GameRepository
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
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindGameRepository(gameRepositoryImpl: GameRepositoryImpl): GameRepository
}