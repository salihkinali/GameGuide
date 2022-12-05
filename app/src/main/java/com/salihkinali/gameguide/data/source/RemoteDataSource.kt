package com.salihkinali.gameguide.data.source

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.TotalGameResponse

interface RemoteDataSource {
    suspend fun getTopAnimeCharacters(): NetworkResponse<TotalGameResponse>
    suspend fun getSingleCharacter(id: Long): NetworkResponse<SingleGameResponse>
}