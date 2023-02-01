package com.salihkinali.domain.usecase

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGameScreenUseCaseImpl @Inject constructor(
    private val repository: GameRepository
) : GetGameScreenShotUseCase {
    override fun invoke(gameId: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>> = flow {
        emit(NetworkResponse.Loading)
        emit(repository.getGameScreenShots(gameId))
    }
}