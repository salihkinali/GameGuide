package com.salihkinali.domain.single

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.singleGameEntity
import com.salihkinali.domain.usecase.GetSingleGameUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class FakeSingleGameUseCase : GetSingleGameUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override fun invoke(id: Int): Flow<NetworkResponse<SingleGameEntity>> = flow{
        emit(NetworkResponse.Loading)
        if (showError){
            emit(NetworkResponse.Error(IOException()))
        }else{
            emit(NetworkResponse.Success(singleGameEntity))
        }
    }
}