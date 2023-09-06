package me.elrevin.user_account_domain

import me.elrevin.user_account_domain.usecase.LoadUserData

data class UserAccountUseCases(
    val loadUserData: LoadUserData
)
