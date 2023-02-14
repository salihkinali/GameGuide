package com.salihkinali.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.GAME_ID
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameRepositoryTest {
    private val fakeGameRepository = FakeGameRepository()

    /**
     Total Game Test
     */
    @Test
    fun totalGameResponse_whenRemoteDataSource_ReturnSuccess_returnSuccess() {
        runBlocking {
            fakeGameRepository.getTotalGameInfo().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun totalGameResponse_whenRemoteDataSource_ReturnError_returnError() {
        runBlocking {
            fakeGameRepository.updateShowErrorForTotalGameResponse(true)
            fakeGameRepository.getTotalGameInfo().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

    /* Single Game Test */

    @Test
    fun singleGameResponse_whenRemoteDataSource_ReturnSuccess_returnSuccess() {
        runBlocking {
            fakeGameRepository.getSingleGameInfo(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun singleGameResponse_whenRemoteDataSource_ReturnError_returnError() {
        runBlocking {
            fakeGameRepository.updateShowErrorForSingleGameResponse(true)
            fakeGameRepository.getSingleGameInfo(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

    /* Game ScreenShot Test */

    @Test
    fun gameScreenShotResponse_whenRemoteDataSource_ReturnSuccess_returnSuccess() {
        runBlocking {
            fakeGameRepository.getGameScreenShots(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun gameScreenShotResponse_whenRemoteDataSource_ReturnError_returnError() {
        runBlocking {
            fakeGameRepository.updateShowErrorForGameScreenShotResponse(true)
            fakeGameRepository.getGameScreenShots(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

}