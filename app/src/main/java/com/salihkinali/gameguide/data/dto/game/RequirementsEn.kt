package com.salihkinali.gameguide.data.dto.game


import com.google.gson.annotations.SerializedName

data class RequirementsEn(
    @SerializedName("minimum")
    val minimum: String?,
    @SerializedName("recommended")
    val recommended: String?
)