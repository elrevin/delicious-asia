package me.elrevin.user_account_data.di

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.elrevin.user_account_data.UserRepositoryImpl
import me.elrevin.user_account_data.local.UserAccountLocalDs
import me.elrevin.user_account_data.local.UserAccountLocalDsImpl
import me.elrevin.user_account_data.remote.UserAccountApi
import me.elrevin.user_account_data.remote.UserAccountApiImpl
import me.elrevin.user_account_domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideUserAccountLocalDs(
        @ApplicationContext context: Context
    ): UserAccountLocalDs = UserAccountLocalDsImpl(
        context.getSharedPreferences("userData", Context.MODE_PRIVATE)
    )

    @Provides
    @Singleton
    fun provideUserAccountApi(
        apolloClient: ApolloClient
    ): UserAccountApi = UserAccountApiImpl(apolloClient)

    @Provides
    @Singleton
    fun provideUserRepository(
        api: UserAccountApi,
        localDs: UserAccountLocalDs
    ): UserRepository = UserRepositoryImpl(api, localDs)
}