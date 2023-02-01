package com.salihkinali.domain.usecase

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.TotalGameEntity
import kotlinx.coroutines.flow.Flow

interface GetTotalGameUseCase {
    operator fun invoke(): Flow<NetworkResponse<List<TotalGameEntity>>>
}