package com.salihkinali.gameguide.data.repository

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.TotalGameResponse
import com.salihkinali.gameguide.data.source.RemoteDataSource
import com.salihkinali.gameguide.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GameRepository {

    override suspend fun getTotalGameInfo(): NetworkResponse<TotalGameResponse> =
    withContext(ioDispatcher) {
        try {
            remoteDataSource.getTotalGameInfo()
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }
    }

    override suspend fun getSingleGameInfo(id: Long): NetworkResponse<SingleGameResponse> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getSingleCharacter(id)
            } catch (e: Exception) {
                NetworkResponse.Error(e)
            }
        }
}
