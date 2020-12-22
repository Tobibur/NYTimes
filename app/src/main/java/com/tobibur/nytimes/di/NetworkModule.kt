package com.tobibur.nytimes.di

import com.tobibur.nytimes.data.network.ApiService
import com.tobibur.nytimes.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get<HttpLoggingInterceptor>())
            addInterceptor { chain ->
                val request = chain.request()
                val oldUrl = request.url
                val newUrl = oldUrl.newBuilder()
                    .addQueryParameter("api-key", AppConstants.API_KEY)
                    .build()
                val reqBuilder = request.newBuilder().url(newUrl)
                chain.proceed(reqBuilder.build())
            }
        }.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}