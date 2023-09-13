package me.elrevin.user_account_presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.elrevin.user_account_domain.UserAccountUseCases
import javax.inject.Inject
import me.elrevin.core_ui.R as CoreUiRes

@HiltViewModel
class RegisterScreenVM @Inject constructor(
    private val useCases: UserAccountUseCases
) : ViewModel() {
    var state by mutableStateOf(RegisterScreenState())
        private set

    fun onEvent(event: RegisterScreenEvent) {
        when (event) {
            RegisterScreenEvent.OnRegisterButtonClick -> {
                register()
            }

            is RegisterScreenEvent.OnNameChange -> {
                state = state.copy(name = event.name)
            }

            is RegisterScreenEvent.OnLoginChange -> {
                state = state.copy(login = event.login)
            }

            is RegisterScreenEvent.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }

            RegisterScreenEvent.OnSkipButtonClick -> {
                skip()
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                state = state.copy(
                    progressVisible = true,
                    error = null
                )
                val res = useCases.register(state.name, state.login, state.password)
                state = state.copy(progressVisible = false)

                when {
                    res.isSuccess() -> {
                        state = state.copy(registerSuccessful = true)
                    }
                    res.isFailure() -> state = state.copy(error = res.getFailureCodeOrNull()!!)
                    res.isException() -> state =
                        state.copy(error = CoreUiRes.string.api_exception)
                }
            }
        }
    }

    private fun skip() {
        useCases.skipAuthorization()
        state = state.copy(skipAuthorization = true)
    }

}