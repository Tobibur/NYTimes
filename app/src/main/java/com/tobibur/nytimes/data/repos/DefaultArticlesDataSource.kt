package com.tobibur.nytimes.data.repos

import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.Outcome

interface DefaultArticlesDataSource {

    suspend fun fetchArticles(period: Int): Outcome<MostPopularArticles>
}