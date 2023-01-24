package com.salihkinali.gameguide.ui.home

import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.data.mapper.GameListMapper
import javax.inject.Inject

class TotalGameUiDataImpl @Inject constructor() :
    GameListMapper<TotalGameEntity, TotalGameUiData> {
    override fun map(input: List<TotalGameEntity>?): List<TotalGameUiData> {
        return input?.map {
            TotalGameUiData(
                id = it.id,
                name = it.name,
                rating = it.rating,
                released = it.released,
                backgroundImage = it.backgroundImage
            )
        } ?: emptyList()
    }
}