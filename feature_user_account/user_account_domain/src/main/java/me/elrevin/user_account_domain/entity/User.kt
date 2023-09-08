package me.elrevin.user_account_domain.entity

data class User(
    val token: String,
    val name: String,
    val authorizationSkipped: Boolean = false,
)
