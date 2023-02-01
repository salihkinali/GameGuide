package com.salihkinali.domain.repository

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity


interface GameRepository {
    suspend fun getTotalGameInfo(): NetworkResponse<List<TotalGameEntity>>
    suspend fun getSingleGameInfo(id: Int): NetworkResponse<SingleGameEntity>
    suspend fun getGameScreenShots(id: Int): NetworkResponse<List<GameScreenShotEntity>>
}