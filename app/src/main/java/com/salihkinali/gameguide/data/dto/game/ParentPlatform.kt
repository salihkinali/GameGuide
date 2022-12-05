package com.salihkinali.gameguide.data.dto.game


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    @SerializedName("platform")
    val platform: Platform?
)