package com.salihkinali.gameguide.data.source

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.api.GameApi
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.Result
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
        }catch (e:Exception){
            NetworkResponse.Error(e)
        }
    }
}