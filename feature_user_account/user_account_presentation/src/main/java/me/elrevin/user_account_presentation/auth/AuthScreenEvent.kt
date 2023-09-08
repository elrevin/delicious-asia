package me.elrevin.user_account_presentation.auth

sealed class AuthScreenEvent {
    data class OnLoginChange(val login: String): AuthScreenEvent()
    data class OnPasswordChange(val password: String): AuthScreenEvent()
    object OnAuthButtonClick: AuthScreenEvent()
    object OnSkipButtonClick: AuthScreenEvent()
}