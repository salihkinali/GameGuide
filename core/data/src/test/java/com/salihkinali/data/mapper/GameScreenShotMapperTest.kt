package com.salihkinali.data.mapper

import com.salihkinali.data.gameScreenShots
import com.salihkinali.domain.entity.GameScreenShotEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameScreenShotMapperTest {

    private val gameScreenShotMapper = GameScreenShotMapper()
    private lateinit var gameScreenShotList: List<GameScreenShotEntity>

    @Before
    fun setup(){
        gameScreenShotList = gameScreenShotMapper.map(gameScreenShots)
    }

    @Test
    fun totalGameScreenShotListSize_whenGameScreenShotMapped_isSameSize(){
        Assert.assertEquals(gameScreenShotList.size, gameScreenShots.size)
    }

    @Test
    fun firstGameScreenShots_backGroundImage_whenGameScreenShotMapped_isSameSize(){
        Assert.assertEquals(gameScreenShotList.first().gameScreenShot, gameScreenShots.first().image)
    }

    @Test
    fun lastGameScreenShots_backGroundImage_whenGameScreenShotMapped_isSameSize(){
        Assert.assertEquals(gameScreenShotList.last().gameScreenShot, gameScreenShots.last().image)
    }

}