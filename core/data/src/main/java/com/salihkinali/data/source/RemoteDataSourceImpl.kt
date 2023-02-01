package com.salihkinali.data.source

import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.api.GameApi
import com.salihkinali.data.dto.detail.SingleGameResponse
import com.salihkinali.data.dto.detail.screenshots.GameResult
import com.salihkinali.data.dto.game.Result
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: GameApi) : RemoteDataSource {
        override suspend fun getTotalGameInfo(): NetworkResponse<List<Result>> {
            return try {
                val response = api.getTotalGameInfo().results
                NetworkResponse.Success(response!!)
            } catch (e: Exception) {
                NetworkResponse.Error(e)
            }
        }

    override suspend fun getSingleCharacter(id: Int): NetworkResponse<SingleGameResponse> {
        return try {
            val response = api.getSingleGameInfo(id)
            NetworkResponse.Success(response)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }
    }

    override suspend fun getGameScreenShots(id: Int): NetworkResponse<List<GameResult>> {
        return try {
            val response = api.getGameScreenShots(id).results
            NetworkResponse.Success(response!!)
        }catch (e:Exception){
            NetworkResponse.Error(e)
        }
    }

}