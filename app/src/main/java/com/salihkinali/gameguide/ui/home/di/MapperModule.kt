package com.salihkinali.gameguide.ui.home.di

import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.ui.home.TotalGameUiData
import com.salihkinali.gameguide.ui.home.TotalGameUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

     @Binds
     @ViewModelScoped
     abstract fun bindTotalGameUiData(totalGameUiDataImpl: TotalGameUiMapperImpl): GameListMapper<TotalGameEntity, TotalGameUiData>

}