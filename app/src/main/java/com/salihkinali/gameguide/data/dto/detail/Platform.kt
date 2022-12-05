package com.salihkinali.gameguide.data.dto.detail


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("name")
    val name: String?,
    @SerializedName("platform")
    val platform: Int?,
    @SerializedName("slug")
    val slug: String?
)