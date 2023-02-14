package com.salihkinali.domain.single

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.salihkinali.common.NetworkResponse
import com.salihkinali.domain.GAME_ID
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetSingleGameUseCaseTest {
    private val fakeSingleGameUseCase = FakeSingleGameUseCase()

    @Test
    fun networkState_whenStateLoading_returnLoading() {
        runBlocking {
            fakeSingleGameUseCase(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndSuccess_returnLoadingAndSuccessSequentially() {
        runBlocking {
            fakeSingleGameUseCase(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndError_returnError() {
        runBlocking {
            fakeSingleGameUseCase.updateShowError(true)
            fakeSingleGameUseCase(GAME_ID).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }
}