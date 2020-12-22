package com.tobibur.nytimes.data.network

import com.tobibur.nytimes.data.model.MostPopularArticles
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{period}.json")
    suspend fun getMostPopularArticles(
        @Path("period") period: Int
    ): MostPopularArticles
}