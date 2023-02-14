package com.salihkinali.data.mapper

import com.salihkinali.data.gameResults
import com.salihkinali.domain.entity.TotalGameEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TotalEntityMapperTest {

    private val totalGameMapper = TotalEntityMapper()

    private lateinit var totalGameEntities: List<TotalGameEntity>

    @Before
    fun setup(){
        totalGameEntities = totalGameMapper.map(gameResults)
    }

    @Test
     fun totalGameListSize_whenGameMapped_isSameSize() {
        assertEquals(totalGameEntities.size, gameResults.size)
    }

    @Test
    fun name_whenGameMappedWithName_isSame() {
        assertEquals(totalGameEntities.first().name, gameResults.first().name)
    }

    @Test
    fun rating_whenGameMappedWithRating_isSame(){
        assertEquals(totalGameEntities.first().rating, gameResults.first().rating)
    }

    @Test
    fun id_whenGameMappedWithId_isSame(){
        assertEquals(totalGameEntities.first().id, gameResults.first().id)
    }

    @Test
    fun released_whenGameMappedWithReleased_isSame(){
        assertEquals(totalGameEntities.first().released, gameResults.first().released)
    }

    @Test
    fun lastGameName_whenGameeMapped_isSame() {
        assertEquals(totalGameEntities.last().name, totalGameEntities.last().name)
    }
}