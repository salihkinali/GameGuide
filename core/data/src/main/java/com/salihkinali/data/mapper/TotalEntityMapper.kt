package com.salihkinali.data.mapper

import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.domain.entity.TotalGameEntity
import javax.inject.Inject
import com.salihkinali.data.dto.game.Result

class TotalEntityMapper @Inject constructor() : GameListMapper<Result, TotalGameEntity> {
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