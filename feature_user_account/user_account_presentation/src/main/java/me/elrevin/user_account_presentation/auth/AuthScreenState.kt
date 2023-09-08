package me.elrevin.user_account_presentation.auth

data class AuthScreenState(
    val login: String = "",
    val password: String = "",

    /**
     * Resource string with error message
     */
    val error: Int? = null,

    val errorStr: String = "",
    val progressVisible: Boolean = false,
    val authSuccessful: Boolean = false,
    val skipAuthorization: Boolean = false,
)
