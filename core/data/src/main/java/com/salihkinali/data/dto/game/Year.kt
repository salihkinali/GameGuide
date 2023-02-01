package com.salihkinali.data.dto.game


import com.google.gson.annotations.SerializedName

data class Year(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("decade")
    val decade: Int?,
    @SerializedName("filter")
    val filter: String?,
    @SerializedName("from")
    val from: Int?,
    @SerializedName("nofollow")
    val nofollow: Boolean?,
    @SerializedName("to")
    val to: Int?,
    @SerializedName("years")
    val years: List<YearX>?
)