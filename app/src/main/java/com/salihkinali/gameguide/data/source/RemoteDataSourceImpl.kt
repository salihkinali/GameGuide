package com.salihkinali.gameguide.data.source

import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.api.GameApi
import com.salihkinali.gameguide.data.dto.detail.SingleGameResponse
import com.salihkinali.gameguide.data.dto.game.TotalGameResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: GameApi) : RemoteDataSource {
    override suspend fun getTopAnimeCharacters(): NetworkResponse<TotalGameResponse> {
        return try {
            val response = api.getGameInfo("2234")
            NetworkResponse.Success(response)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }
    }

    override suspend fun getSingleCharacter(id: Long): NetworkResponse<SingleGameResponse> {
        return try {
            val response = api.getSingleGameInfo(id,"2234")
            NetworkResponse.Success(response)
        }catch (e:Exception){
            NetworkResponse.Error(e)
        }
    }
}