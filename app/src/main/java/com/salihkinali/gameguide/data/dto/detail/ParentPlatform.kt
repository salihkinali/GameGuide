package com.salihkinali.gameguide.data.dto.detail


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    @SerializedName("platform")
    val platform: PlatformX?
)