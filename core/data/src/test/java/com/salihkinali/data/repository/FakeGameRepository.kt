package com.salihkinali.data.repository

import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.gameScreenShotEntities
import com.salihkinali.data.totalGameEntities
import com.salihkinali.data.singleGameEntity
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity
import com.salihkinali.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class FakeGameRepository : GameRepository {

    private var showErrorForTotalGameResponse = false
    private var showErrorForSingleGameResponse = false
    private var showErrorForGameScreenShotResponse = false

    fun updateShowErrorForTotalGameResponse(response: Boolean) {
        this.showErrorForTotalGameResponse = response
    }

    fun updateShowErrorForSingleGameResponse(response: Boolean) {
        this.showErrorForSingleGameResponse = response
    }

    fun updateShowErrorForGameScreenShotResponse(response: Boolean) {
        this.showErrorForGameScreenShotResponse = response
    }

    override fun getTotalGameInfo(): Flow<NetworkResponse<List<TotalGameEntity>>> = flow {
        emit(NetworkResponse.Loading)
        if (showErrorForTotalGameResponse) {
            emit(NetworkResponse.Error(IOException()))
        } else {
            emit(NetworkResponse.Success(totalGameEntities))
        }
    }

    override fun getSingleGameInfo(id: Int): Flow<NetworkResponse<SingleGameEntity>> = flow {
        emit(NetworkResponse.Loading)
        if (showErrorForSingleGameResponse) {
            emit(NetworkResponse.Error(IOException()))
        } else {
            emit(NetworkResponse.Success(singleGameEntity))
        }
    }

    override fun getGameScreenShots(id: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>> =
        flow {
            emit(NetworkResponse.Loading)
            if (showErrorForGameScreenShotResponse) {
                emit(NetworkResponse.Error(IOException()))
            } else {
                emit(NetworkResponse.Success(gameScreenShotEntities))
            }
        }
}