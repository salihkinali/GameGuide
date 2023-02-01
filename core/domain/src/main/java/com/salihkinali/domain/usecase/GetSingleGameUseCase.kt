package com.salihkinali.domain.usecase

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.SingleGameEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleGameUseCase {

    operator fun invoke(id: Int): Flow<NetworkResponse<SingleGameEntity>>

}