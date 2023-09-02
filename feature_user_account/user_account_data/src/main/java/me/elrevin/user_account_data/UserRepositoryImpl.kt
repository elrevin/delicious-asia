package me.elrevin.user_account_data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.elrevin.user_account_data.entity.UserEntity
import me.elrevin.user_account_data.local.UserAccountLocalDs
import me.elrevin.user_account_data.mapper.toUser
import me.elrevin.user_account_data.remote.UserAccountApi
import me.elrevin.user_account_domain.entity.User
import me.elrevin.user_account_domain.repository.UserRepository

class UserRepositoryImpl (
    private val api: UserAccountApi,
    private val localDs: UserAccountLocalDs
) : UserRepository {
    private val user: UserEntity? = localDs.getUser()

    override fun getUser(): User? = user?.toUser()

    override suspend fun loadUserData(): Flow<User> {
        if (user != null) {
            return flow {
                emit(user.toUser())
            }
        }

        return flow {
            val result = api.loadUserData("")
        }
    }
}