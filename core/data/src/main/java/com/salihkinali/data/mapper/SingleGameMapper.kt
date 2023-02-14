package com.salihkinali.data.mapper

import com.salihkinali.common.mapper.GameMapper
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.domain.entity.SingleGameEntity
import javax.inject.Inject

class SingleGameMapper @Inject constructor() :
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


