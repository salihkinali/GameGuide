package com.salihkinali.data.source

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.salihkinali.common.NetworkResponse
import com.salihkinali.data.GAME_ID
import com.salihkinali.data.api.GameApi
import com.salihkinali.data.gameScResponse
import com.salihkinali.data.singleGameResponse
import com.salihkinali.data.totalGameResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RemoteDataSourceTest {

    @Mock
    private lateinit var gameApi: GameApi

    private lateinit var remoteDataSource: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = RemoteDataSourceImpl(gameApi)
    }


    /* Total Game Response Test */

    @Test
    fun totalGameResponse_whenApiReturnSuccess_isResponseStateSuccess() {
        runBlocking {
            Mockito.`when`(gameApi.getTotalGameInfo()).thenReturn(totalGameResponse)
            remoteDataSource.getTotalGameInfo().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun totalGameResponse_whenApiReturnNull_isResponseStateError() {
        runBlocking {
            Mockito.`when`(gameApi.getTotalGameInfo()).thenReturn(null)
            remoteDataSource.getTotalGameInfo().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

    /* Single Game Response Test */

    @Test
    fun singleGameResponse_whenApiReturnSuccess_isResponseStateSuccess() {
        runBlocking {
            Mockito.`when`(gameApi.getSingleGameInfo(GAME_ID)).thenReturn(
                singleGameResponse
            )

            remoteDataSource.getSingleCharacter(GAME_ID).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun singleGameResponse_whenApiReturnSuccess_isResponseStateError() {
        runBlocking {
            Mockito.`when`(gameApi.getSingleGameInfo(GAME_ID)).thenReturn(null)

            remoteDataSource.getSingleCharacter(GAME_ID).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

    /* Game ScreenShot Test */


    @Test
    fun gameScreenShotResponse_whenApiReturnSuccess_isResponseStateSuccess() {
        runBlocking {
            Mockito.`when`(gameApi.getGameScreenShots(GAME_ID)).thenReturn(gameScResponse)

            remoteDataSource.getGameScreenShots(GAME_ID).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun gameScreenShotResponse_whenApiReturnSuccess_isResponseStateError() {
        runBlocking {
            Mockito.`when`(gameApi.getGameScreenShots(GAME_ID)).thenReturn(null)

            remoteDataSource.getGameScreenShots(GAME_ID).test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

}