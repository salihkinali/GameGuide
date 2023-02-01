package com.salihkinali.feature.detail.di

import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.common.mapper.GameMapper
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.feature.detail.GameScreenShotUiData
import com.salihkinali.feature.detail.GameScreenShotUiMapperImpl
import com.salihkinali.feature.detail.SingleGameUiData
import com.salihkinali.feature.detail.SingleGameUiDataImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DetailMapperModule {


    @Binds
    @ViewModelScoped
    abstract fun bindGameScreenShotMapper(gameScreenShotUiMapperImpl: GameScreenShotUiMapperImpl):
            GameListMapper<GameScreenShotEntity, GameScreenShotUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleUiMapper(singleGameUiDataImpl: SingleGameUiDataImpl): GameMapper<SingleGameEntity, SingleGameUiData>


}