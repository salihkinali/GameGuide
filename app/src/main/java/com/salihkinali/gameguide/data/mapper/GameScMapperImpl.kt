package com.salihkinali.gameguide.data.mapper

import com.salihkinali.gameguide.data.dto.detail.screenshots.GameResult
import com.salihkinali.gameguide.domain.entity.GameScreenShotEntity
import javax.inject.Inject

class GameScMapperImpl @Inject constructor() : GameListMapper<GameResult, GameScreenShotEntity> {
    override fun map(input: List<GameResult>?): List<GameScreenShotEntity> {
        return input?.map {
            GameScreenShotEntity(
                gameScreenShot = it.image.orEmpty()
            )
        } ?: emptyList()
    }
}
