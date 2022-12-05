package com.salihkinali.gameguide.data.dto.detail


import com.google.gson.annotations.SerializedName

data class PlatformXX(
    @SerializedName("platform")
    val platform: PlatformXXX?,
    @SerializedName("released_at")
    val releasedAt: String?,
    @SerializedName("requirements")
    val requirements: Requirements?
)