package com.salihkinali.gameguide.domain.repository

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.TotalGameResponse

interface GameRepository {
    suspend fun getTotalGameInfo(): NetworkResponse<TotalGameResponse>
    suspend fun getSingleGameInfo(id: Long): NetworkResponse<SingleGameResponse>
}