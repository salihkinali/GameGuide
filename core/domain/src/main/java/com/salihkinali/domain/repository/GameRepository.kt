package com.salihkinali.domain.repository

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity
import kotlinx.coroutines.flow.Flow


interface GameRepository {
     fun getTotalGameInfo(): Flow<NetworkResponse<List<TotalGameEntity>>>
     fun getSingleGameInfo(id: Int): Flow<NetworkResponse<SingleGameEntity>>
     fun getGameScreenShots(id: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>>
}