package com.tobibur.nytimes.data.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.ApiService
import com.tobibur.nytimes.data.network.Outcome

class ArticlesDataSource(private val apiService: ApiService): DefaultArticlesDataSource {


    override suspend fun fetchArticles(period: Int): Outcome<MostPopularArticles> {
        val articleResponse = MutableLiveData<Outcome<MostPopularArticles>>()
        try {
            val articles = apiService.getMostPopularArticles(period)
            articleResponse.value = Outcome.success(articles)
        } catch (e: Exception) {
            articleResponse.value = Outcome.failure(e)
        }
        return articleResponse.value as Outcome<MostPopularArticles>
    }
}