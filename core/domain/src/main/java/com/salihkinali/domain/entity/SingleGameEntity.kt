package com.salihkinali.domain.entity

data class SingleGameEntity(
    val id: Int,
    val name: String,
    val released: String,
    val backgroundImage: String,
    val description: String,
    val website: String,
    val ratingTop: Int,
)
