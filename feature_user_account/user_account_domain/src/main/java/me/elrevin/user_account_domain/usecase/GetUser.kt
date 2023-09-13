package me.elrevin.user_account_domain.usecase

import me.elrevin.user_account_domain.repository.UserRepository

class GetUser (
    private val repository: UserRepository
) {
    operator fun invoke() = repository.getUser()
}