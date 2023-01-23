package com.salihkinali.gameguide.data.repository

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.Result
import com.salihkinali.gameguide.data.mapper.GameListMapper
import com.salihkinali.gameguide.data.mapper.GameMapper
import com.salihkinali.gameguide.data.source.RemoteDataSource
import com.salihkinali.gameguide.di.coroutine.IoDispatcher
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.domain.repository.GameRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val gameListMapper: GameListMapper<Result, TotalGameEntity>,
    private val gameMapper: GameMapper<SingleGameResponse, SingleGameEntity>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GameRepository {
    override suspend fun getTotalGameInfo(): NetworkResponse<List<TotalGameEntity>> =

        withContext(ioDispatcher) {
            when (val response = remoteDataSource.getTotalGameInfo()) {
                is NetworkResponse.Success -> {
                    NetworkResponse.Success(gameListMapper.map(response.result))
                }
                is NetworkResponse.Error -> NetworkResponse.Error(response.exception)

                NetworkResponse.Loading -> NetworkResponse.Loading
            }
        }

    override suspend fun getSingleGameInfo(id: Long): NetworkResponse<SingleGameEntity> =
        withContext(ioDispatcher) {
            when (val response = remoteDataSource.getSingleCharacter(id)) {

                 NetworkResponse.Loading -> NetworkResponse.Loading
                is NetworkResponse.Error -> NetworkResponse.Error(response.exception)
                is NetworkResponse.Success -> NetworkResponse.Success(gameMapper.map(response.result))

            }
        }

}
