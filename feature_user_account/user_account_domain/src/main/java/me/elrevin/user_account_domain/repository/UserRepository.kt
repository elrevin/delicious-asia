package me.elrevin.user_account_domain.repository

import me.elrevin.core.Either
import me.elrevin.user_account_domain.entity.User

interface UserRepository {

    /**
     * Get user data from shared preferences
     */
    fun getUser(): User?

    /**
     * Check user data in shared preferences, refresh it from server
     */
    suspend fun loadUserData(): Either<User?>

    suspend fun auth(login: String, password: String): Either<User?>

    suspend fun register(name: String, login: String, password: String): Either<User?>

    fun skipAuthorization()
}