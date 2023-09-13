package me.elrevin.user_account_presentation.auth

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
class AuthScreenVM @Inject constructor(
    val useCases: UserAccountUseCases
) : ViewModel() {
    var state by mutableStateOf(AuthScreenState())
        private set

    fun onEvent(event: AuthScreenEvent) {
        when (event) {
            AuthScreenEvent.OnAuthButtonClick -> {
                auth()
            }

            is AuthScreenEvent.OnLoginChange -> {
                state = state.copy(login = event.login)
            }

            is AuthScreenEvent.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }

            AuthScreenEvent.OnSkipButtonClick -> {
                skip()
            }
        }
    }

    private fun auth() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                state = state.copy(
                    progressVisible = true,
                    error = null
                )
                val res = useCases.auth(state.login, state.password)
                state = state.copy(progressVisible = false)

                when {
                    res.isSuccess() -> {
                        state = state.copy(authSuccessful = true)
                    }
                    res.isFailure() -> state = state.copy(error = res.getFailureCodeOrNull()!!)
                    res.isException() -> state =
                        state.copy(error = 1)
                }
            }
        }
    }

    private fun skip() {
        useCases.skipAuthorization()
        state = state.copy(skipAuthorization = true)
    }
}