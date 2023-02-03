package com.salihkinali.domain.usecase

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.TotalGameEntity
import com.salihkinali.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalGameUseCaseImpl @Inject constructor(
    private val repository: GameRepository,
) : GetTotalGameUseCase {
    override fun invoke(): Flow<NetworkResponse<List<TotalGameEntity>>> = repository.getTotalGameInfo()
}