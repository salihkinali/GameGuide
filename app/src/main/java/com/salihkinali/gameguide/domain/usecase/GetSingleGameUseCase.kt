package com.salihkinali.gameguide.domain.usecase

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleGameUseCase {

    operator fun invoke(id: Int): Flow<NetworkResponse<SingleGameEntity>>

}