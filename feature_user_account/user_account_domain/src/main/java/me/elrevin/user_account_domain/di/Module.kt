package me.elrevin.user_account_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.elrevin.user_account_domain.UserAccountUseCases
import me.elrevin.user_account_domain.repository.UserRepository
import me.elrevin.user_account_domain.usecase.LoadUserData
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideUserAccountUseCases(
        repository: UserRepository
    ): UserAccountUseCases {
        return UserAccountUseCases(
            loadUserData = LoadUserData(repository)
        )
    }
}