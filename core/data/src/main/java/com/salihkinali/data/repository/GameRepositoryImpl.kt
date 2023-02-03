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
import com.salihkinali.mapResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val gameListMapper: GameListMapper<Result, TotalGameEntity>,
    private val gameScMapper: GameListMapper<GameResult, GameScreenShotEntity>,
    private val gameMapper: GameMapper<SingleGameResponse, SingleGameEntity>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GameRepository {
    override  fun getTotalGameInfo(): Flow<NetworkResponse<List<TotalGameEntity>>> =
        remoteDataSource.getTotalGameInfo().map {data->
          data.mapResponse { gameListMapper.map(this) }
        }

    override  fun getSingleGameInfo(id: Int): Flow<NetworkResponse<SingleGameEntity>> =
        remoteDataSource.getSingleCharacter(id).map {data->
            data.mapResponse { gameMapper.map(this) }
        }
    override  fun getGameScreenShots(id: Int): Flow<NetworkResponse<List<GameScreenShotEntity>>> =
        remoteDataSource.getGameScreenShots(id).map {data->
            data.mapResponse { gameScMapper.map(this) }
        }

}
