package me.elrevin.user_account_presentation.register

sealed class RegisterScreenEvent {
    data class OnNameChange(val name: String): RegisterScreenEvent()
    data class OnLoginChange(val login: String): RegisterScreenEvent()
    data class OnPasswordChange(val password: String): RegisterScreenEvent()
    object OnRegisterButtonClick: RegisterScreenEvent()
    object OnSkipButtonClick: RegisterScreenEvent()
}