package com.salihkinali.feature.home

import com.salihkinali.domain.entity.TotalGameEntity
import com.salihkinali.common.mapper.GameListMapper
import javax.inject.Inject

class TotalGameUiMapperImpl @Inject constructor() :
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