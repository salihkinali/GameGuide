package com.salihkinali.gameguide.di.usecase

import com.salihkinali.gameguide.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTotalGameUseCase(gameUseCaseImpl: GetTotalGameUseCaseImpl):GetTotalGameUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSingleGameUseCase(singleGameUseCase: GetSingleGameUseCaseImpl):GetSingleGameUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGameScreenShotUseCase(gameScreenShotUseCaseImp: GetGameScreenUseCaseImpl):GetGameScreenShotUseCase
}