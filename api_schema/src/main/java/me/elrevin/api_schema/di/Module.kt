package me.elrevin.api_schema.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.elrevin.api_schema.ApiConfig
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = run {
        val okHttpClient = OkHttpClient
            .Builder()
            .retryOnConnectionFailure(true)
            .addNetworkInterceptor{
                val request = it.request().newBuilder()
                    .addHeader("Connection", "close")
                    .build()
                it.proceed(request)
            }
            .build()
        ApolloClient.Builder()
            .serverUrl(ApiConfig.url)
            .okHttpClient(okHttpClient)
            .build()
    }
}