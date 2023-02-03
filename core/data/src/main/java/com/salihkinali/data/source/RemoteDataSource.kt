package com.salihkinali.data.source

import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.dto.game.Result
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
     fun getTotalGameInfo(): Flow<NetworkResponse<List<Result>>>
     fun getSingleCharacter(id: Int): Flow<NetworkResponse<SingleGameResponse>>
     fun getGameScreenShots(id: Int): Flow<NetworkResponse<List<GameResult>>>
}