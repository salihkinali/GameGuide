package com.salihkinali.domain.total

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.salihkinali.common.NetworkResponse
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetTotalGameUseCaseTest {

    private val fakeGetTotalGameUseCase = FakeGetTotalGameUseCase()

    @Test
    fun networkState_whenStateLoading_returnLoading() {
        runBlocking {
            fakeGetTotalGameUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndSuccess_returnLoadingAndSuccessSequentially() {
        runBlocking {
            fakeGetTotalGameUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndError_returnError() {
        runBlocking {
            fakeGetTotalGameUseCase.updateShowError(true)
            fakeGetTotalGameUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }
}