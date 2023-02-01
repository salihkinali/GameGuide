package com.salihkinali.data.di

import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.common.mapper.GameMapper
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.mapper.GameScMapperImpl
import com.salihkinali.data.mapper.SingleGameMapperImpl
import com.salihkinali.data.mapper.TotalEntityMapperImpl
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import com.salihkinali.data.dto.game.Result

@Module
@InstallIn(ViewModelComponent::class)
abstract class GameMapperModule {



    @Binds
    @ViewModelScoped
    abstract fun bindSingleMapper(singleMapperImpl: SingleGameMapperImpl): GameMapper<SingleGameResponse, SingleGameEntity>

//    @Binds
//    @ViewModelScoped
//    abstract fun bindGameScreenShotMapper(gameScreenShotUiMapperImpl: GameScreenShotUiMapperImpl):
//            GameListMapper<GameScreenShotEntity, GameScreenShotUiData>

//    @Binds
//    @ViewModelScoped
//    abstract fun bindSingleUiMapper(singleGameUiDataImpl: SingleGameUiDataImpl): GameMapper<SingleGameEntity, SingleGameUiData>

   @Binds
   @ViewModelScoped
    abstract fun bindGameMapper(totalEntityMapperImpl: TotalEntityMapperImpl): GameListMapper<Result, TotalGameEntity>

    // @Binds
   // @ViewModelScoped
   // abstract fun bindTotalGameUiData(totalGameUiDataImpl: TotalGameUiMapperImpl): GameListMapper<TotalGameEntity, TotalGameUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindGameScMapper(gameScMapperImpl: GameScMapperImpl): GameListMapper<GameResult, GameScreenShotEntity>

}