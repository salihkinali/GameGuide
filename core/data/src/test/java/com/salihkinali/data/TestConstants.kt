package com.salihkinali.data

import androidx.annotation.VisibleForTesting
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.dto.detail.screenshots.SingleGameScreenShotResponse
import com.salihkinali.data.dto.game.Result
import com.salihkinali.data.dto.game.TotalGameResponse
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
val singleGameResponse = SingleGameResponse(
    achievementsCount = null,
    added = null,
    addedByStatus = null,
    additionsCount = null,
    alternativeNames = null,
    backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
    backgroundImageAdditional = null,
    clip = null,
    creatorsCount = null,
    description = "Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos",
    descriptionRaw = null,
    developers = null,
    dominantColor = null,
    esrbRating = null,
    gameSeriesCount = null,
    genres = null,
    id = 3498,
    metacritic = null,
    metacriticPlatforms = null,
    metacriticUrl = null,
    moviesCount = null,
    name = "Grand Theft Auto V",
    nameOriginal = null,
    parentAchievementsCount = null,
    parentPlatforms = null,
    parentsCount = null,
    platforms = null,
    playtime = null,
    publishers = null,
    rating = null,
    ratingTop = 5,
    ratings = null,
    ratingsCount = null,
    reactions = null,
    redditCount = null,
    redditDescription = null,
    redditLogo = null,
    redditName = null,
    redditUrl = "https://www.reddit.com/r/GrandTheftAutoV/",
    released = "2013-09-17",
    reviewsCount = null,
    reviewsTextCount = null,
    saturatedColor = null,
    screenshotsCount = 57,
    slug = "grand-theft-auto-v",
    stores = null,
    suggestionsCount = null,
    tags = null,
    tba = null,
    twitchCount = null,
    updated = null,
    userGame = null,
    website = "http://www.rockstargames.com/V/",
    youtubeCount = null
)

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


@VisibleForTesting
val gameScreenShotEntity = GameScreenShotEntity(
    gameScreenShot = "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg"
)

@VisibleForTesting
val gameScreenShotEntities = listOf(gameScreenShotEntity)

@VisibleForTesting
val result = Result(
    added = null,
    addedByStatus = null,
    backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
    clip = null,
    dominantColor = null,
    esrbRating = null,
    genres = null,
    id = 3498,
    metacritic = null,
    name = "Grand Theft Auto V",
    parentPlatforms = null,
    platforms = null,
    playtime = null,
    rating = 4.47,
    ratingTop = 5,
    ratings = null,
    ratingsCount = null,
    released = "2013-09-17",
    reviewsCount = null,
    reviewsTextCount = null,
    saturatedColor = "0f0f0f",
    shortScreenshots = null,
    slug = null,
    stores = null,
    suggestionsCount = null,
    tags = null,
    tba = false,
    updated = "2023-02-02T07:58:58",
    userGame = null
)

@VisibleForTesting
val gameResults = listOf(result)

@VisibleForTesting
val gameScreenShot = GameResult(
    height = null,
    id = null,
    image = "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
    isDeleted = false,
    width = null
)

@VisibleForTesting
val gameScreenShots = listOf(gameScreenShot)

@VisibleForTesting
val totalGameResponse = TotalGameResponse(
    count = null,
    description = null,
    filters = null,
    next = null,
    nofollow = false,
    nofollowCollections = null,
    noindex = false,
    previous = null,
    results = gameResults,
    seoDescription = null,
    seoH1 = null,
    seoKeywords = null,
    seoTitle = null
)

@VisibleForTesting
val singleGameItemResponse = singleGameResponse

@VisibleForTesting
val gameScResponse = SingleGameScreenShotResponse(
    count = null,
    next = null,
    previous = null,
    results = gameScreenShots
)

