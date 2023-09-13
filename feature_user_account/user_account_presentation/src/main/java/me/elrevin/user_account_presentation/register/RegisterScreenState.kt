package me.elrevin.user_account_presentation.register

data class RegisterScreenState(
    val name: String = "",
    val login: String = "",
    val password: String = "",

    /**
     * Resource string with error message
     */
    val error: Int? = null,

    val progressVisible: Boolean = false,
    val registerSuccessful: Boolean = false,
    val skipAuthorization: Boolean = false,
)
