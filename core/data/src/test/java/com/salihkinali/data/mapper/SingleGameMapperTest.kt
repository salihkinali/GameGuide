package com.salihkinali.data.mapper

import com.salihkinali.data.singleGameResponse
import com.salihkinali.domain.entity.SingleGameEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SingleGameMapperTest {
    private val singleGameMapper = SingleGameMapperImpl()
    private lateinit var singleGameEntity: SingleGameEntity

    @Before
    fun setup(){
        singleGameEntity = singleGameMapper.map(singleGameResponse)
    }

    @Test
    fun name_whenGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.name, singleGameResponse.name)
    }

    @Test
    fun image_whenSingleGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.backgroundImage, singleGameResponse.backgroundImage)
    }

    @Test
    fun id_whenSingleGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.id, singleGameResponse.id)
    }

    @Test
    fun released_whenSingleGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.released, singleGameResponse.released)
    }

    @Test
    fun description_whenSingleGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.description, singleGameResponse.description)
    }

    @Test
    fun website_whenSingleGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.website, singleGameResponse.website)
    }

    @Test
    fun ratingTop_whenSingleGameMapped_isSameSize() {
        Assert.assertEquals(singleGameEntity.ratingTop, singleGameResponse.ratingTop)
    }


}