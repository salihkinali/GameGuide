package com.salihkinali.gameguide.ui.detail

import com.salihkinali.gameguide.data.mapper.GameListMapper
import com.salihkinali.gameguide.domain.entity.GameScreenShotEntity
import javax.inject.Inject

class GameScreenShotUiMapperImpl @Inject constructor() : GameListMapper<GameScreenShotEntity, GameScreenShotUiData> {
    override fun map(input: List<GameScreenShotEntity>?): List<GameScreenShotUiData> {
        return input?.map {
            GameScreenShotUiData(
                gameShotData = it.gameScreenShot
            )
        } ?: emptyList()
    }
}