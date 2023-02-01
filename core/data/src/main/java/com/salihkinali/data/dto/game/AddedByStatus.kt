package com.salihkinali.data.dto.game


import com.google.gson.annotations.SerializedName

data class AddedByStatus(
    @SerializedName("beaten")
    val beaten: Int?,
    @SerializedName("dropped")
    val dropped: Int?,
    @SerializedName("owned")
    val owned: Int?,
    @SerializedName("playing")
    val playing: Int?,
    @SerializedName("toplay")
    val toplay: Int?,
    @SerializedName("yet")
    val yet: Int?
)