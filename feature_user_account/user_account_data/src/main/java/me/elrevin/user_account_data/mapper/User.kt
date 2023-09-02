package me.elrevin.user_account_data.mapper

import me.elrevin.user_account_data.entity.UserEntity
import me.elrevin.user_account_domain.entity.User

fun UserEntity.toUser(): User = User(
    token = this.token,
    name = this.name
)