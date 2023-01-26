package com.salihkinali.gameguide.ui.detail

import com.salihkinali.gameguide.data.mapper.GameMapper
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import javax.inject.Inject


class SingleGameUiDataImpl @Inject constructor() : GameMapper<SingleGameEntity, SingleGameUiData> {
    override fun map(input: SingleGameEntity): SingleGameUiData {
        return SingleGameUiData(
            id = input.id,
            name = input.name,
            released = input.released,
            backgroundImage = input.backgroundImage,
            description = input.description,
            website = input.website,
            ratingTop = input.ratingTop
        )
    }
}