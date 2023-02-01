package com.salihkinali.domain.usecase

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.GameScreenShotEntity
import kotlinx.coroutines.flow.Flow

interface GetGameScreenShotUseCase {
    operator fun invoke(gameId: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>>
}