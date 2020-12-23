package com.tobibur.nytimes.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.Outcome
import com.tobibur.nytimes.data.repos.ArticlesRepository

class HomeViewModel(private val articlesRepository: ArticlesRepository) : ViewModel() {

    private var articles: LiveData<Outcome<MostPopularArticles>>? = null

    fun getArticles(period: Int): LiveData<Outcome<MostPopularArticles>> {
        if (articles == null) {
            articles = liveData {
                emit(articlesRepository.getArticles(period))
            }
        }
        return articles as LiveData<Outcome<MostPopularArticles>>
    }
}