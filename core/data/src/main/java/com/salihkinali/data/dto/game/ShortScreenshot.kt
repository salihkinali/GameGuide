package com.salihkinali.data.dto.game


import com.google.gson.annotations.SerializedName

data class ShortScreenshot(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?
)