package com.tobibur.nytimes.data.model


import com.google.gson.annotations.SerializedName

data class MostPopularArticles(
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("status")
    val status: String
)