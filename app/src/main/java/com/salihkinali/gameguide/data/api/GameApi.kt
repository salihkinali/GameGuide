package com.salihkinali.gameguide.data.api

import com.salihkinali.gameguide.BuildConfig
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.detail.screenshots.SingleGameScreenShotResponse
import com.salihkinali.gameguide.data.dto.game.TotalGameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApi {

    @GET("api/games")
    suspend fun getTotalGameInfo(@Query("key") key: String = BuildConfig.API_KEY): TotalGameResponse

    @GET("api/games/{id}")
    suspend fun getSingleGameInfo(
        @Path("id") id: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ): SingleGameResponse

    @GET("/api/games/{game_pk}/screenshots")
    suspend fun getGameScreenShots(
        @Path("game_pk") gamePk: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ):SingleGameScreenShotResponse

}