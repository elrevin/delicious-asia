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
}