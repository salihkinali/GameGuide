package com.salihkinali.domain.screenshots

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.GAME_ID
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetGameScreenShotUseCaseTest {

    private val fakeGetGameScreenShotUseCase = FakeGetGameScreenShotUseCase()

    /* GetGameScreenShotUseCase Test */

    @Test
    fun networkState_whenStateLoading_returnLoading() {
        runBlocking {
            fakeGetGameScreenShotUseCase(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndSuccess_returnLoadingAndSuccessSequentially() {
        runBlocking {
            fakeGetGameScreenShotUseCase(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndError_returnError() {
        runBlocking {
            fakeGetGameScreenShotUseCase.updateShowError(true)
            fakeGetGameScreenShotUseCase(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }
}