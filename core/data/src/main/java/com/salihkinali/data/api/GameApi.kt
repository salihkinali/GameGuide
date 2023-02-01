package com.salihkinali.data.api

import com.salihkinali.data.API_KEY
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.SingleGameScreenShotResponse
import com.salihkinali.data.dto.game.TotalGameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApi {

    @GET("api/games")
    suspend fun getTotalGameInfo(@Query("key") key: String = API_KEY): TotalGameResponse

    @GET("api/games/{id}")
    suspend fun getSingleGameInfo(
        @Path("id") id: Int,
        @Query("key") key: String = API_KEY
    ): SingleGameResponse

    @GET("/api/games/{game_pk}/screenshots")
    suspend fun getGameScreenShots(
        @Path("game_pk") gamePk: Int,
        @Query("key") key: String = API_KEY
    ): SingleGameScreenShotResponse

}