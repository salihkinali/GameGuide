package com.salihkinali.data.source

import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.dto.game.Result

interface RemoteDataSource {
    suspend fun getTotalGameInfo(): NetworkResponse<List<Result>>
    suspend fun getSingleCharacter(id: Int): NetworkResponse<SingleGameResponse>
    suspend fun getGameScreenShots(id: Int): NetworkResponse<List<GameResult>>
}