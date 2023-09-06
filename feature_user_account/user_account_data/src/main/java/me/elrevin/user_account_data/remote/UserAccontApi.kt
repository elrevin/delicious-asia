package me.elrevin.user_account_data.remote

import me.elrevin.core.Either
import me.elrevin.user_account_data.entity.UserEntity

interface UserAccountApi {
    suspend fun loadUserData(token: String): Either<UserEntity?>

    suspend fun registerUser(name: String, login: String, password: String): Either<UserEntity>

    suspend fun authUser(login: String, password: String): Either<UserEntity>
}