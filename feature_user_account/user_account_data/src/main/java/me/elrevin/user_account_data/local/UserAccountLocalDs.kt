package me.elrevin.user_account_data.local

import me.elrevin.user_account_data.entity.UserEntity

interface UserAccountLocalDs {
    fun getUser(): UserEntity?

    fun saveUser(userEntity: UserEntity)

    fun skipAuthorization()

    fun authorizationSkipped(): Boolean
}