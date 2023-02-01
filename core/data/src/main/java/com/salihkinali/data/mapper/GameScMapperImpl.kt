package com.salihkinali.data.mapper

import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.domain.entity.GameScreenShotEntity
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
