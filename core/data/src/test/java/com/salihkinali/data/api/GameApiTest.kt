package com.salihkinali.data.api

import com.google.common.truth.Truth.assertThat
import com.salihkinali.data.*
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameApiTest {


    private lateinit var gameApi: GameApi
    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start(8080)
        gameApi = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build().create(GameApi::class.java)
    }


    /* when conditions is here */

    @Test
    fun when_response_is_not_null() {
        runBlocking {
            readFileResponse(GAME_API_FILE_NAME)
            val response = gameApi.getTotalGameInfo()
            val request = mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun when_game_id_is_requestPath_same() {
        runBlocking {
            readFileResponse(GAME_API_FILE_NAME)
            val response = gameApi.getSingleGameInfo(GAME_ID)
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/api/games/$GAME_ID?key=${BuildConfig.API_KEY}")
        }
    }

    @Test
    fun when_game_response_is_requestPath_same() {
        runBlocking {
            readFileResponse(GAME_API_FILE_NAME)
            val response = gameApi.getTotalGameInfo()
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/api/games?key=${BuildConfig.API_KEY}")
        }
    }


    @Test
    fun when_response_is_firstGameId_expected() {
        runBlocking {
            readFileResponse(GAME_API_FILE_NAME)
            val response = gameApi.getTotalGameInfo()
            val firstGame = response.results!!.first()
            assertThat(firstGame.id).isEqualTo(GAME_ID)
        }
    }

    @Test
    fun when_game_name_has_same_response_expected() {
        runBlocking {
            readFileResponse(SINGLE_GAME_API_FILE_NAME)
            val response = gameApi.getSingleGameInfo(GAME_ID)
            val gameName = response.name
            assertThat(gameName).isEqualTo(GAME_NAME)
        }
    }


    // This is Read File
    private fun readFileResponse(fileName: String) {
        javaClass.classLoader?.let {

            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shotDown() {
        mockWebServer.shutdown()
    }
}