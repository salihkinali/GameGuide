package com.salihkinali.data.dto.game


import com.google.gson.annotations.SerializedName

data class YearX(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("nofollow")
    val nofollow: Boolean?,
    @SerializedName("year")
    val year: Int?
)