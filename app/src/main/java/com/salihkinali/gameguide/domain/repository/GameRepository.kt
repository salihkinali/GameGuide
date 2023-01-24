package com.salihkinali.gameguide.domain.repository

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import com.salihkinali.gameguide.domain.entity.TotalGameEntity


interface GameRepository {
    suspend fun getTotalGameInfo(): NetworkResponse<List<TotalGameEntity>>
    suspend fun getSingleGameInfo(id: Int):NetworkResponse<SingleGameEntity>
}