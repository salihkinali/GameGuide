package com.salihkinali.data.repository

import com.salihkinali.common.NetworkResponse
import com.salihkinali.common.coroutine.IoDispatcher
import com.salihkinali.common.mapper.GameListMapper
import com.salihkinali.common.mapper.GameMapper
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.dto.game.Result
import com.salihkinali.data.source.RemoteDataSource
import com.salihkinali.domain.entity.GameScreenShotEntity
import com.salihkinali.domain.entity.SingleGameEntity
import com.salihkinali.domain.entity.TotalGameEntity
import com.salihkinali.domain.repository.GameRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val gameListMapper: GameListMapper<Result, TotalGameEntity>,
    private val gameScMapper: GameListMapper<GameResult, GameScreenShotEntity>,
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

    override suspend fun getSingleGameInfo(id: Int): NetworkResponse<SingleGameEntity> =
        withContext(ioDispatcher) {

            when (val response = remoteDataSource.getSingleCharacter(id)) {

                 NetworkResponse.Loading -> NetworkResponse.Loading
                is NetworkResponse.Error -> NetworkResponse.Error(response.exception)
                is NetworkResponse.Success -> NetworkResponse.Success(gameMapper.map(response.result))

            }
        }

    override suspend fun getGameScreenShots(id: Int): NetworkResponse<List<GameScreenShotEntity>> =

        withContext(ioDispatcher) {
           when (val response = remoteDataSource.getGameScreenShots(id)) {

                is NetworkResponse.Success -> {
                    NetworkResponse.Success(gameScMapper.map(response.result))
                }
                is NetworkResponse.Error -> NetworkResponse.Error(response.exception)

                NetworkResponse.Loading -> NetworkResponse.Loading
            }
        }

}
