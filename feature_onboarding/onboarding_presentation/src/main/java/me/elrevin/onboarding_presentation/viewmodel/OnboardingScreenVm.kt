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
import me.elrevin.core_ui.R as CoreUiRes
import me.elrevin.user_account_domain.UserAccountUseCases
import me.elrevin.user_account_domain.entity.User
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenVm  @Inject constructor(
    private val userAccountUseCases: UserAccountUseCases
): ViewModel() {
    var state: OnboardingClassState by mutableStateOf(OnboardingClassState.Default)
        private set

    init {
        viewModelScope.launch {
            state = OnboardingClassState.Loading
            val result = loadUserData()
            if (result.isSuccess()) {
                state = OnboardingClassState.LoadingIsSuccessful(result.getValue() != null)
            }

            if (result.isFailure()) {
                state = OnboardingClassState.Failure(result.getFailureMessageOrNull()!!)
            }

            if (result.isException()) {
                state = OnboardingClassState.Failure(CoreUiRes.string.api_exception)
            }
        }
    }

    private suspend fun loadUserData(): Either<User?> = withContext(Dispatchers.IO) {
        userAccountUseCases.loadUserData()
    }
}

sealed class OnboardingClassState{
    object Default: OnboardingClassState()
    object Loading: OnboardingClassState()
    class Failure(val message: String? = null): OnboardingClassState() {

        var messageRes: Int? = null
            private set

        constructor(messageRes: Int) : this() {
            this.messageRes = messageRes
        }
    }

    class LoadingIsSuccessful(val userAuthorizedOrSkipped: Boolean): OnboardingClassState()
}