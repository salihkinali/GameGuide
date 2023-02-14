package com.salihkinali.data

import androidx.annotation.VisibleForTesting
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity

const val GAME_API_FILE_NAME = "TotalGameInfoResponse.json"
const val SINGLE_GAME_API_FILE_NAME = "SingleGameInfoResponse.json"
const val GAME_ID = 3498
const val GAME_NAME = "Grand Theft Auto V"

@VisibleForTesting
val totalGameEntity = TotalGameEntity(
    id = 3498,
    name = "Grand Theft Auto V",
    rating = 4.47,
    released = "2013-09-17",
    backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg"
)

@VisibleForTesting
val totalGameEntities = listOf(totalGameEntity)

@VisibleForTesting
val singleGameEntity = SingleGameEntity(
    id = 3498,
    name = "Grand Theft Auto V",
    released = "2013-09-17",
    backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
    description = "<p>Rockstar Games went bigger, since their previous installment of the series." +
            " You get the complicated and realistic world-building from Liberty City of GTA4 in the" +
            " setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas." +
            " 561 different vehicles (including every transport you can operate) and the amount is " +
            "rising with every update. <br />\nSimultaneous storytelling from three unique " +
            "perspectives: <br />\nFollow Michael, ex-criminal living his life of leisure away from " +
            "the past, Franklin, a kid that seeks the better future, and Trevor, the exact past Michael" +
            " is trying to run away from. <br />\nGTA Online will provide a lot of additional challenge" +
            " even for the experienced players, coming fresh from the story mode. Now you will have other" +
            " players around that can help you just as likely as ruin your mission. Every GTA mechanic up " +
            "to date can be experienced by players through the unique customizable character, and" +
            " community content paired with the leveling system tends to keep everyone busy and engaged.</p>",
    website = "http://www.rockstargames.com/V/",
    ratingTop = 5
)

@VisibleForTesting
val gameScreenShotEntity = GameScreenShotEntity(
    gameScreenShot = "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg"
)

@VisibleForTesting
val gameScreenShotEntities = listOf(gameScreenShotEntity)