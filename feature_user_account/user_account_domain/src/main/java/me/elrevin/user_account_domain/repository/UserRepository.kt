package me.elrevin.user_account_domain.repository

import kotlinx.coroutines.flow.Flow
import me.elrevin.user_account_domain.entity.User

interface UserRepository {
    fun getUser(): User?

    suspend fun loadUserData(): Flow<User>
}