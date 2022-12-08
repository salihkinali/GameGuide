package com.salihkinali.gameguide.domain.usecase

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import kotlinx.coroutines.flow.Flow

interface GetTotalGameUseCase {
    operator fun invoke(): Flow<NetworkResponse<List<TotalGameEntity>>>
}