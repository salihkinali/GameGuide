package com.salihkinali.domain.screenshots

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.gameScreenShotEntities
import com.salihkinali.domain.usecase.GetGameScreenShotUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class FakeGetGameScreenShotUseCase: GetGameScreenShotUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override fun invoke(gameId: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>> = flow {
        emit(NetworkResponse.Loading)
        if (showError){
            emit(NetworkResponse.Error(IOException()))
        }else{
            emit(NetworkResponse.Success(gameScreenShotEntities))
        }
    }
}