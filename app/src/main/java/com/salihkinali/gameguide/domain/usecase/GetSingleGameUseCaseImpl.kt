package com.salihkinali.gameguide.domain.usecase

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import com.salihkinali.gameguide.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleGameUseCaseImpl @Inject constructor(
    private val repository: GameRepository,
) : GetSingleGameUseCase {
    override fun invoke(id:Long): Flow<NetworkResponse<SingleGameEntity>> = flow {

        emit(NetworkResponse.Loading)
        emit(repository.getSingleGameInfo(id))
    }
}
