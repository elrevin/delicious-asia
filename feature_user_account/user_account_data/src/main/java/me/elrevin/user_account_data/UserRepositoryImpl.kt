package me.elrevin.user_account_data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.elrevin.core.Either
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
    private val user: UserEntity?
        get() = localDs.getUser()

    private val authorizationSkipped: Boolean
        get() = localDs.authorizationSkipped()

    override fun getUser(): User? = user?.toUser()

    override suspend fun loadUserData(): Either<User?> {
        if (user != null) {
            val res = api.loadUserData(user?.token ?: "")

            if (res.isSuccess()) {
                if (res.getValue() != null) {
                    localDs.saveUser(res.getValue()!!)
                }
                return Either.success(res.getValue()?.toUser())
            }
            return Either.fromEither(res)
        } else if (authorizationSkipped) {
            return Either.success(User(token = "", name = "", authorizationSkipped = true))
        } else {
            return Either.success(null)
        }
    }

    override suspend fun auth(login: String, password: String): Either<User?> {
        val res = api.authUser(login, password)
        if (res.isSuccess()) {
            if (res.getValue() != null) {
                localDs.saveUser(res.getValue()!!)
            }
            return Either.success(res.getValue()?.toUser())
        }
        return Either.fromEither(res)
    }

    override suspend fun register(name: String, login: String, password: String): Either<User?> {
        val res = api.registerUser(name, login, password)
        if (res.isSuccess()) {
            if (res.getValue() != null) {
                localDs.saveUser(res.getValue()!!)
            }
            return Either.success(res.getValue()?.toUser())
        }
        return Either.fromEither(res)
    }

    override fun skipAuthorization() {
        localDs.skipAuthorization()
    }
}