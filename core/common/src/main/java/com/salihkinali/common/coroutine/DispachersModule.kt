package com.salihkinali.common.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object DispachersModule {

    @IoDispatcher
    @Provides
    @ViewModelScoped
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}