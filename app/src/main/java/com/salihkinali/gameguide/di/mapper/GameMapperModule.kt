package com.salihkinali.gameguide.di.mapper

import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.data.mapper.GameListMapper
import com.salihkinali.gameguide.data.dto.game.Result
import com.salihkinali.gameguide.data.mapper.GameMapper
import com.salihkinali.gameguide.data.mapper.SingleGameMapperImpl
import com.salihkinali.gameguide.data.mapper.TotalEntityMapperImpl
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import com.salihkinali.gameguide.ui.detail.SingleGameUiData
import com.salihkinali.gameguide.ui.detail.SingleGameUiDataImpl
import com.salihkinali.gameguide.ui.home.TotalGameUiData
import com.salihkinali.gameguide.ui.home.TotalGameUiDataImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class GameMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGameMapper(totalEntityMapperImpl: TotalEntityMapperImpl): GameListMapper<Result, TotalGameEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleMapper(singleMapperImpl: SingleGameMapperImpl): GameMapper<SingleGameResponse, SingleGameEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleUiMapper(singleGameUiDataImpl: SingleGameUiDataImpl): GameMapper<SingleGameEntity, SingleGameUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindTotalGameUiData(totalGameUiDataImpl: TotalGameUiDataImpl): GameListMapper<TotalGameEntity, TotalGameUiData>

}