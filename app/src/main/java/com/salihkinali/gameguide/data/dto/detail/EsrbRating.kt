package com.salihkinali.gameguide.data.dto.detail


import com.google.gson.annotations.SerializedName

data class EsrbRating(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)