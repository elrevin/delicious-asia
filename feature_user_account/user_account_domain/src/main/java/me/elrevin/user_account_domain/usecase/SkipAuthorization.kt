package me.elrevin.user_account_domain.usecase

import me.elrevin.user_account_domain.repository.UserRepository

class SkipAuthorization (
    private val repository: UserRepository
) {
    operator fun invoke() {
        repository.skipAuthorization()
    }
}