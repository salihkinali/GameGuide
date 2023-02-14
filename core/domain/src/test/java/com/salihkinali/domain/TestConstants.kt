package com.salihkinali.domain

import androidx.annotation.VisibleForTesting
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity

@VisibleForTesting
val totalGameEntity = TotalGameEntity(
    id = 3498,
    name = "Grand Theft Auto V",
    rating = 4.47,
    released = "2013-09-17",
    backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg"
)

@VisibleForTesting
val gameScreenShotEntity = GameScreenShotEntity(
    gameScreenShot = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg"
)

@VisibleForTesting
val gameScreenShotEntities = listOf(gameScreenShotEntity)

@VisibleForTesting
val totalGameEntities = listOf(totalGameEntity)

@VisibleForTesting
val singleGameEntity = SingleGameEntity(
    id = 3498,
    name = "Grand Theft Auto V",
    released = "2013-09-17",
    backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
    description = "Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos",
    website = "http://www.rockstargames.com/V/",
    ratingTop = 5
)

const val GAME_ID: Int = 3498

