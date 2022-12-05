package com.salihkinali.gameguide.data.dto.detail


import com.google.gson.annotations.SerializedName

data class PlatformXXX(
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: Any?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("year_end")
    val yearEnd: Any?,
    @SerializedName("year_start")
    val yearStart: Int?
)