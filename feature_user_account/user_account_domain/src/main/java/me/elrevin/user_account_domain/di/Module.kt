package me.elrevin.user_account_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import me.elrevin.user_account_domain.UserAccountUseCases
import me.elrevin.user_account_domain.repository.UserRepository
import me.elrevin.user_account_domain.usecase.Auth
import me.elrevin.user_account_domain.usecase.GetUser
import me.elrevin.user_account_domain.usecase.LoadUserData
import me.elrevin.user_account_domain.usecase.Register
import me.elrevin.user_account_domain.usecase.SkipAuthorization
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
            loadUserData = LoadUserData(repository),
            auth = Auth(repository),
            register = Register(repository),
            skipAuthorization = SkipAuthorization(repository),
            getUser = GetUser(repository),
        )
    }
}