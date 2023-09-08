package me.elrevin.onboarding_presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.elrevin.core.Either
import me.elrevin.user_account_domain.UserAccountUseCases
import me.elrevin.user_account_domain.entity.User
import javax.inject.Inject
import me.elrevin.core_ui.R as CoreUiRes

@HiltViewModel
class OnboardingScreenVm  @Inject constructor(
    private val userAccountUseCases: UserAccountUseCases
): ViewModel() {
    var state: OnboardingClassState by mutableStateOf(OnboardingClassState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(loading = true)
            val result = loadUserData()
            state = state.copy(loading = false)
            if (result.isSuccess()) {
                state = if (result.getValue() == null) {
                    state.copy(unAuthorized = true)
                } else {
                    state.copy(authorizedOrSkipped = true)
                }
            }

            if (result.isFailure()) {
                state = state.copy(errorStr = result.getFailureMessageOrNull()!!)
            }

            if (result.isException()) {
                state = state.copy(errorId = CoreUiRes.string.api_exception)
            }
        }
    }

    private suspend fun loadUserData(): Either<User?> = withContext(Dispatchers.IO) {
        userAccountUseCases.loadUserData()
    }
}

data class OnboardingClassState (
    val loading: Boolean = false,
    val errorId: Int? = null,
    val errorStr: String = "",
    val authorizedOrSkipped: Boolean = false,
    val unAuthorized: Boolean = false,
)