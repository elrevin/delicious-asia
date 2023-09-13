package me.elrevin.user_account_presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.elrevin.core.Routes
import me.elrevin.user_account_presentation.auth.AuthScreen
import me.elrevin.user_account_presentation.auth.AuthScreenEvent
import me.elrevin.user_account_presentation.auth.AuthScreenVM
import me.elrevin.user_account_presentation.register.RegisterScreen
import me.elrevin.user_account_presentation.register.RegisterScreenEvent
import me.elrevin.user_account_presentation.register.RegisterScreenState
import me.elrevin.user_account_presentation.register.RegisterScreenVM

fun NavGraphBuilder.userAccountNavigation(navController: NavController) {
    composable(Routes.userAccountAuthScreen.path, enterTransition = {
        EnterTransition.None
    }) {
        val vm: AuthScreenVM = hiltViewModel()
        val state = vm.state
        AuthScreen(
            state = state,
            onSuccessfulAuth = {
                navController.navigate(Routes.homeScreenRoot.path) {
                    popUpTo(Routes.userAccountAuthScreen.path) {
                        inclusive = true
                    }
                }
            },
            onRegister = {
                navController.navigate(Routes.userAccountRegisterScreen.path) {
                    popUpTo(Routes.userAccountAuthScreen.path) {
                        inclusive = true
                    }
                }
            },
            onSkip = {
                navController.navigate(Routes.homeScreenRoot.path) {
                    popUpTo(Routes.userAccountAuthScreen.path) {
                        inclusive = true
                    }
                }
            },
            onLoginChange = { vm.onEvent(AuthScreenEvent.OnLoginChange(it)) },
            onPasswordChange = { vm.onEvent(AuthScreenEvent.OnPasswordChange(it)) },
            onAuthButtonClick = { vm.onEvent(AuthScreenEvent.OnAuthButtonClick) },
            onSkipButtonClick = { vm.onEvent(AuthScreenEvent.OnSkipButtonClick) }
        )
    }

    composable(Routes.userAccountRegisterScreen.path, enterTransition = {
        EnterTransition.None
    }) {
        val vm: RegisterScreenVM = hiltViewModel()
        val state: RegisterScreenState = vm.state
        RegisterScreen(
            state = state,
            onSuccessfulRegister = {
                navController.navigate(Routes.homeScreenRoot.path) {
                    popUpTo(Routes.userAccountRegisterScreen.path) {
                        inclusive = true
                    }
                }
            },
            onAuth = {
                navController.navigate(Routes.userAccountAuthScreen.path) {
                    popUpTo(Routes.userAccountRegisterScreen.path) {
                        inclusive = true
                    }
                }
            },
            onSkip = {
                navController.navigate(Routes.homeScreenRoot.path) {
                    popUpTo(Routes.userAccountRegisterScreen.path) {
                        inclusive = true
                    }
                }
            },
            onNameChange = { vm.onEvent(RegisterScreenEvent.OnNameChange(it)) },
            onLoginChange = { vm.onEvent(RegisterScreenEvent.OnLoginChange(it)) },
            onPasswordChange = { vm.onEvent(RegisterScreenEvent.OnPasswordChange(it)) },
            onRegisterButtonClick = { vm.onEvent(RegisterScreenEvent.OnRegisterButtonClick) },
            onSkipButtonClick = { vm.onEvent(RegisterScreenEvent.OnSkipButtonClick) }
        )
    }
}