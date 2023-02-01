package com.salihkinali.data.dto.detail.screenshots


import com.google.gson.annotations.SerializedName

data class SingleGameScreenShotResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: Any?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<GameResult>?
)