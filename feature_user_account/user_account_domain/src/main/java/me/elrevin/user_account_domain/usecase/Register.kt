package me.elrevin.user_account_domain.usecase

import me.elrevin.core.Either
import me.elrevin.user_account_domain.entity.User
import me.elrevin.user_account_domain.repository.UserRepository

class Register (
    private val repository: UserRepository
) {
    suspend operator fun invoke(name: String, login: String, password: String): Either<User?> =
        repository.register(name, login, password)
}