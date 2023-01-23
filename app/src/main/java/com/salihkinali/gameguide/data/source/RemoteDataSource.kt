package com.salihkinali.gameguide.data.source

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.Result

interface RemoteDataSource {
    suspend fun getTotalGameInfo(): NetworkResponse<List<Result>>
    suspend fun getSingleCharacter(id: Long): NetworkResponse<SingleGameResponse>
}