package me.elrevin.user_account_domain

import me.elrevin.user_account_domain.usecase.Auth
import me.elrevin.user_account_domain.usecase.LoadUserData
import me.elrevin.user_account_domain.usecase.Register
import me.elrevin.user_account_domain.usecase.SkipAuthorization

data class UserAccountUseCases(
    val loadUserData: LoadUserData,
    val auth: Auth,
    val register: Register,
    val skipAuthorization: SkipAuthorization,
)
