package com.salihkinali.gameguide.domain.usecase

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.dto.game.Result
import com.salihkinali.gameguide.domain.repository.GameRepository
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.domain.mapper.GameListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTotalGameUseCaseImpl @Inject constructor(
    private val repository: GameRepository,
    private val gameListMapper: GameListMapper<Result, TotalGameEntity>
) : GetTotalGameUseCase {
    override fun invoke(): Flow<NetworkResponse<List<TotalGameEntity>>> = flow {
        emit(NetworkResponse.Loading)
        when (val response = repository.getTotalGameInfo()) {
            is NetworkResponse.Error -> emit(response)
            is NetworkResponse.Loading -> Unit
            is NetworkResponse.Success -> emit(
                NetworkResponse.Success(gameListMapper.map(response.result.results))
            )
        }

    }
}