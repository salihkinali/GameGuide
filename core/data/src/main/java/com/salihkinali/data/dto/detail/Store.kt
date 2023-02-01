package com.salihkinali.data.dto.detail


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("store")
    val store: StoreX?,
    @SerializedName("url")
    val url: String?
)