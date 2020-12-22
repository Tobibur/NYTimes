package com.tobibur.nytimes.data.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.ApiService
import com.tobibur.nytimes.data.network.Outcome

class ArticlesDataSource(private val apiService: ApiService) {

    private val _articleResponse = MutableLiveData<Outcome<MostPopularArticles>>()
    val articleResponse: LiveData<Outcome<MostPopularArticles>>
        get() = _articleResponse

    suspend fun fetchArticles(period: Int) {
        try {
            val articles = apiService.getMostPopularArticles(period)
            _articleResponse.value = Outcome.success(articles)
        } catch (e: Exception) {
            _articleResponse.value = Outcome.failure(e)
        }
    }
}