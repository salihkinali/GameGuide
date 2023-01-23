package com.salihkinali.gameguide.data.mapper

import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import javax.inject.Inject

class SingleGameMapperImpl @Inject constructor() :
    GameMapper<SingleGameResponse, SingleGameEntity> {
    override fun map(input: SingleGameResponse): SingleGameEntity {
        return SingleGameEntity(
            id = input.id!!.toLong(),
            name = input.name!!,
            released = input.released!!,
            backgroundImage = input.backgroundImage!!,
            description = input.descriptionRaw!!,
            website = input.website!!,
            ratingTop = input.ratingTop!!
        )
    }
}


