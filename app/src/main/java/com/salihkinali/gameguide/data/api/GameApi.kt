package com.salihkinali.gameguide.data.api

import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.TotalGameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApi {

    @GET("api/games")
    suspend fun getTotalGameInfo(@Query("key") key: String): TotalGameResponse

    @GET("api/games/{id}/")
    suspend fun getSingleGameInfo(@Path("id") id: Long, @Query("key") key: String): SingleGameResponse
}