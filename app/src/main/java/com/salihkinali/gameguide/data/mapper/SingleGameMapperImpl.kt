package com.salihkinali.gameguide.data.mapper

import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import javax.inject.Inject

class SingleGameMapperImpl @Inject constructor() :
    GameMapper<SingleGameResponse, SingleGameEntity> {
    override fun map(input: SingleGameResponse): SingleGameEntity {
        return SingleGameEntity(
            id = input.id ?: 0,
            name = input.name.orEmpty(),
            released = input.released.orEmpty(),
            backgroundImage = input.backgroundImage.orEmpty(),
            description = input.descriptionRaw.orEmpty(),
            website = input.website.orEmpty(),
            ratingTop = input.ratingTop ?: 0
        )
    }
}


