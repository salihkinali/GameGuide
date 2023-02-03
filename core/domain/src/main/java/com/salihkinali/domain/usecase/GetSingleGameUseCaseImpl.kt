package com.salihkinali.domain.usecase

import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleGameUseCaseImpl @Inject constructor(
    private val repository: GameRepository,
) : GetSingleGameUseCase {
    override fun invoke(id:Int): Flow<NetworkResponse<SingleGameEntity>> = repository.getSingleGameInfo(id)
}
