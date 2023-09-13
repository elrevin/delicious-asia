package me.elrevin.user_account_data.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.Query
import me.elrevin.core.Either
import me.elrevin.core.getLanguage
import me.elrevin.user_account_data.AuthMutation
import me.elrevin.user_account_data.RegisterUserMutation
import me.elrevin.user_account_data.UserDataQuery
import me.elrevin.user_account_data.entity.UserEntity
import javax.inject.Inject

class UserAccountApiImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : UserAccountApi {
    suspend fun doRegisterUser(
        mutation: Mutation<RegisterUserMutation.Data>
    ): Either<UserEntity> {
        try {
            val response = apolloClient.mutation(
                mutation
            ).execute().dataAssertNoErrors

            if (response.registerUser?.onError != null) {
                return Either.failure(response.registerUser.onError.errorCode)
            }

            val userData = response.registerUser!!.onUserData!!
            return Either.success(
                UserEntity(
                    token = userData.token,
                    name = userData.name
                )
            )
        } catch (e: Exception) {
            return Either.exception(e)
        }
    }

    override suspend fun registerUser(
        name: String,
        login: String,
        password: String
    ): Either<UserEntity?> =
        doRegisterUser(RegisterUserMutation(getLanguage(), name, login, password))

    suspend fun doLoadUserData(query: Query<UserDataQuery.Data>): Either<UserEntity?> {
        try {
            val response = apolloClient.query(
                query
            ).execute().dataAssertNoErrors

            if (response.userData == null) {
                return Either.success(null)
            }

            val userData = response.userData
            return Either.success(
                UserEntity(
                    token = userData.token,
                    name = userData.name
                )
            )
        } catch (e: Exception) {
            return Either.exception(e)
        }
    }
    override suspend fun loadUserData(token: String): Either<UserEntity?> =
        doLoadUserData(UserDataQuery(token))

    suspend fun doAuthUser(mutation: Mutation<AuthMutation.Data>): Either<UserEntity?> {
        try {
            val response = apolloClient.mutation(
                mutation
            ).execute().dataAssertNoErrors

            if (response.auth?.onError != null) {
                return Either.failure(response.auth.onError.errorCode)
            }

            val userData = response.auth!!.onUserData!!
            return Either.success(
                UserEntity(
                    token = userData.token,
                    name = userData.name
                )
            )
        } catch (e: Exception) {
            return Either.exception(e)
        }
    }

    override suspend fun authUser(login: String, password: String): Either<UserEntity?> =
        doAuthUser(AuthMutation(getLanguage(), login, password))

}