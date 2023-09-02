package me.elrevin.user_account_data.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.Query
import me.elrevin.core.Deferred
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
    ): Deferred<UserEntity> {
        try {
            val response = apolloClient.mutation(
                mutation
            ).execute().dataAssertNoErrors

            if (response.registerUser?.onError != null) {
                return Deferred.failure(response.registerUser.onError.errorMessage)
            }

            val userData = response.registerUser!!.onUserData!!
            return Deferred.success(
                UserEntity(
                    token = userData.token,
                    name = userData.name
                )
            )
        } catch (e: Exception) {
            return Deferred.exception(e)
        }
    }

    override suspend fun registerUser(
        name: String,
        login: String,
        password: String
    ): Deferred<UserEntity> =
        doRegisterUser(RegisterUserMutation(getLanguage(), name, login, password))

    suspend fun doLoadUserData(query: Query<UserDataQuery.Data>): Deferred<UserEntity?> {
        try {
            val response = apolloClient.query(
                query
            ).execute().dataAssertNoErrors

            if (response.userData == null) {
                return Deferred.success(null)
            }

            val userData = response.userData
            return Deferred.success(
                UserEntity(
                    token = userData.token,
                    name = userData.name
                )
            )
        } catch (e: Exception) {
            return Deferred.exception(e)
        }
    }
    override suspend fun loadUserData(token: String): Deferred<UserEntity?> =
        doLoadUserData(UserDataQuery(token))

    suspend fun doAuthUser(mutation: Mutation<AuthMutation.Data>): Deferred<UserEntity> {
        try {
            val response = apolloClient.mutation(
                mutation
            ).execute().dataAssertNoErrors

            if (response.auth?.onError != null) {
                return Deferred.failure(response.auth.onError.errorMessage)
            }

            val userData = response.auth!!.onUserData!!
            return Deferred.success(
                UserEntity(
                    token = userData.token,
                    name = userData.name
                )
            )
        } catch (e: Exception) {
            return Deferred.exception(e)
        }
    }

    override suspend fun authUser(login: String, password: String): Deferred<UserEntity> =
        doAuthUser(AuthMutation(getLanguage(), login, password))

}