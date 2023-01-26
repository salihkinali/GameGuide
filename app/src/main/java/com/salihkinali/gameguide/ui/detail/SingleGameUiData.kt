package com.salihkinali.gameguide.ui.detail

data class SingleGameUiData(
    val id: Int,
    val name: String,
    val released: String,
    val backgroundImage: String,
    val description: String,
    val website: String,
    val ratingTop: Int
)