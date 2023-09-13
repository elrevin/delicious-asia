package me.elrevin.user_account_presentation.auth

data class AuthScreenState(
    val login: String = "",
    val password: String = "",

    val error: Int? = null,

    val progressVisible: Boolean = false,
    val authSuccessful: Boolean = false,
    val skipAuthorization: Boolean = false,
)
