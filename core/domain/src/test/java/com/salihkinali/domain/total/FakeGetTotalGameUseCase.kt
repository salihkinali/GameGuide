package com.salihkinali.domain.total

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.TotalGameEntity
import com.salihkinali.domain.totalGameEntities
import com.salihkinali.domain.usecase.GetTotalGameUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class FakeGetTotalGameUseCase: GetTotalGameUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }
    override fun invoke(): Flow<NetworkResponse<List<TotalGameEntity>>> = flow {
        emit(NetworkResponse.Loading)
        if (showError){
            emit(NetworkResponse.Error(IOException()))
        }else{
            emit(NetworkResponse.Success(totalGameEntities))
        }
    }
}