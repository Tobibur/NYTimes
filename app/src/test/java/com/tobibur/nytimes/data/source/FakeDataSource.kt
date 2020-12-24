package com.tobibur.nytimes.data.source

import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.Outcome
import com.tobibur.nytimes.data.repos.DefaultArticlesDataSource
import com.tobibur.nytimes.data.repos.DefaultArticlesRepository
import java.lang.Exception

class FakeDataSource(var articles: MostPopularArticles?) : DefaultArticlesDataSource {

    override suspend fun fetchArticles(period: Int): Outcome<MostPopularArticles> {
        articles?.let { return Outcome.success(it) }
        return Outcome.failure(
            Exception("Articles not found")
        )
    }
}