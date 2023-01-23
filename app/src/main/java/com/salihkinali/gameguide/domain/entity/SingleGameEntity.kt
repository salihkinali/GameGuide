package com.salihkinali.gameguide.domain.entity

data class SingleGameEntity(
    val id: Long,
    val name: String,
    val released: String,
    val backgroundImage: String,
    val description: String,
    val website: String,
    val ratingTop: Int,
)
