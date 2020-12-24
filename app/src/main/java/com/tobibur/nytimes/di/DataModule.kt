package com.tobibur.nytimes.di

import com.tobibur.nytimes.data.repos.ArticlesDataSource
import com.tobibur.nytimes.data.repos.ArticlesRepository
import com.tobibur.nytimes.data.repos.DefaultArticlesDataSource
import com.tobibur.nytimes.data.repos.DefaultArticlesRepository
import org.koin.dsl.module

val dataModule = module {
    single<DefaultArticlesDataSource> { ArticlesDataSource(get()) }
    single<DefaultArticlesRepository> { ArticlesRepository(get()) }
}