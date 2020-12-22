package com.tobibur.nytimes.di

import com.tobibur.nytimes.data.repos.ArticlesRepository
import org.koin.dsl.module

val dataModule = module {
    single { ArticlesRepository(get()) }
}