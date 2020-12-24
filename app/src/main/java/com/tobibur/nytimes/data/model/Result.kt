package com.tobibur.nytimes.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result(
    @SerializedName("abstract")
    val `abstract`: String,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("media")
    val media: List<Media>,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
): Serializable