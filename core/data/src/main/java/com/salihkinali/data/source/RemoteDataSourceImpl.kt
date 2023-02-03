package com.salihkinali.data.source

import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.api.GameApi
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.dto.game.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: GameApi) : RemoteDataSource {
    override fun getTotalGameInfo(): Flow<NetworkResponse<List<Result>>> = flow {
        emit(NetworkResponse.Loading)
        try {
            val response = api.getTotalGameInfo()
            emit(NetworkResponse.Success(response.results!!))
        } catch (e: java.lang.Exception) {
            emit(NetworkResponse.Error(e))
        }
    }


    override fun getSingleCharacter(id: Int): Flow<NetworkResponse<SingleGameResponse>> = flow {
        emit(NetworkResponse.Loading)
        try {
            val response = api.getSingleGameInfo(id)
            emit(NetworkResponse.Success(response))
        } catch (e: Exception) {
            emit(NetworkResponse.Error(e))
        }
    }

    override fun getGameScreenShots(id: Int): Flow<NetworkResponse<List<GameResult>>> = flow {
        emit(NetworkResponse.Loading)
        try {
            val response = api.getGameScreenShots(id).results
            emit(NetworkResponse.Success(response!!))
        } catch (e: Exception) {
            emit(NetworkResponse.Error(e))
        }
    }

}