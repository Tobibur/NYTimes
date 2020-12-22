package com.tobibur.nytimes.data.repos

import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.ApiService
import com.tobibur.nytimes.data.network.Outcome

class ArticlesRepository(private val apiService: ApiService) {

    suspend fun getArticles(period: Int): Outcome<MostPopularArticles> {
        val articlesDataSource = ArticlesDataSource(apiService)
        articlesDataSource.fetchArticles(period)
        return articlesDataSource.articleResponse.value as Outcome<MostPopularArticles>
    }
}