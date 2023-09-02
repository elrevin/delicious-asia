package me.elrevin.user_account_data.remote

import me.elrevin.core.Deferred
import me.elrevin.user_account_data.entity.UserEntity

interface UserAccountApi {
    suspend fun loadUserData(token: String): Deferred<UserEntity?>

    suspend fun registerUser(name: String, login: String, password: String): Deferred<UserEntity>

    suspend fun authUser(login: String, password: String): Deferred<UserEntity>
}