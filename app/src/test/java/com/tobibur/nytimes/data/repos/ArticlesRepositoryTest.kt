package com.tobibur.nytimes.data.repos

import com.tobibur.nytimes.data.model.MostPopularArticles
import com.tobibur.nytimes.data.model.Result
import com.tobibur.nytimes.data.network.Outcome
import com.tobibur.nytimes.data.source.FakeDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticlesRepositoryTest{

    private val results = listOf<Result>(
        Result("abs","tobi", 1, listOf(), "1", "s", "s", "s"),
        Result("abs","tobi", 1, listOf(), "1", "s", "s", "s"),
        Result("abs","tobi", 1, listOf(), "1", "s", "s", "s"),
        Result("abs","tobi", 1, listOf(), "1", "s", "s", "s")
    )

    private val remoteArticles = MostPopularArticles(1, results, "true")

    private lateinit var articlesDataSource: FakeDataSource

    private lateinit var articlesRepository: ArticlesRepository

    @Before
    fun createRepository(){
        articlesDataSource = FakeDataSource(remoteArticles)

        articlesRepository = ArticlesRepository(articlesDataSource)
    }

    @Test
    fun getArticles_requestAllArticlesFromRemoteDataSource() = runBlocking {
        val articles = articlesRepository.fetchArticles(7) as Outcome.Success

        Assert.assertEquals(remoteArticles, articles.data)
    }

}