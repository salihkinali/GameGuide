package com.salihkinali.data.dto.game


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("years")
    val years: List<Year>?
)