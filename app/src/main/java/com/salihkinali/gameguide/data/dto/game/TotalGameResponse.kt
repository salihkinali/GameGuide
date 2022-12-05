package com.salihkinali.gameguide.data.dto.game


import com.google.gson.annotations.SerializedName

data class TotalGameResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("filters")
    val filters: Filters?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("nofollow")
    val nofollow: Boolean?,
    @SerializedName("nofollow_collections")
    val nofollowCollections: List<String>?,
    @SerializedName("noindex")
    val noindex: Boolean?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("seo_description")
    val seoDescription: String?,
    @SerializedName("seo_h1")
    val seoH1: String?,
    @SerializedName("seo_keywords")
    val seoKeywords: String?,
    @SerializedName("seo_title")
    val seoTitle: String?
)