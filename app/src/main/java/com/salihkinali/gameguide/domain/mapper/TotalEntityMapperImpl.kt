package com.salihkinali.gameguide.domain.mapper

import com.salihkinali.gameguide.data.dto.game.Result
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import javax.inject.Inject

class TotalEntityMapperImpl @Inject constructor() : GameListMapper<Result, TotalGameEntity> {
    override fun map(input: List<Result>?): List<TotalGameEntity> {
        return input?.map {
            TotalGameEntity(
                id = it.id ?: 0,
                name = it.name.orEmpty(),
                rating = it.rating ?: 0.00,
                released = it.released.orEmpty(),
                backgroundImage = it.backgroundImage.orEmpty()
            )
        } ?: emptyList()
    }
}