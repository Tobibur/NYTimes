package com.tobibur.nytimes.data.repos

import androidx.lifecycle.LiveData
import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.network.Outcome

interface DefaultArticlesRepository {

    suspend fun fetchArticles(period: Int): Outcome<MostPopularArticles>
}