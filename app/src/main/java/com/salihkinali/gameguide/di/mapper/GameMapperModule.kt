package com.salihkinali.gameguide.di.mapper

import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.domain.mapper.GameListMapper
import com.salihkinali.gameguide.data.dto.game.Result
import com.salihkinali.gameguide.domain.mapper.TotalEntityMapperImpl
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
    abstract fun bindGameMapper(totalEntityMapperImpl: TotalEntityMapperImpl):GameListMapper<Result,TotalGameEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindTotalGameUiData(totalGameUiDataImpl: TotalGameUiDataImpl):GameListMapper<TotalGameEntity,TotalGameUiData>

}