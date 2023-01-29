package com.salihkinali.gameguide.domain.usecase

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.domain.entity.GameScreenShotEntity
import kotlinx.coroutines.flow.Flow

interface GetGameScreenShotUseCase {
    operator fun invoke(gameId: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>>
}