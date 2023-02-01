package com.salihkinali.gameguide.ui.detail

import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.domain.entity.GameScreenShotEntity
import javax.inject.Inject

class GameScreenShotUiMapperImpl @Inject constructor() :
    GameListMapper<GameScreenShotEntity, GameScreenShotUiData> {
    override fun map(input: List<GameScreenShotEntity>?): List<GameScreenShotUiData> {
        return input?.map {
            GameScreenShotUiData(
                gameShotData = it.gameScreenShot
            )
        } ?: emptyList()
    }
}