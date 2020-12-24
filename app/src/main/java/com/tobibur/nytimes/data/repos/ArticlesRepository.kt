package com.tobibur.nytimes.data.repos

import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.ApiService
import com.tobibur.nytimes.data.network.Outcome

class ArticlesRepository(private val articlesDataSource: DefaultArticlesDataSource): DefaultArticlesRepository {

    override suspend fun fetchArticles(period: Int): Outcome<MostPopularArticles> {
        articlesDataSource.fetchArticles(period)
        return articlesDataSource.fetchArticles(period)
    }
}