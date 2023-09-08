package me.elrevin.user_account_presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.elrevin.core.Routes
import me.elrevin.user_account_presentation.auth.AuthScreen
import me.elrevin.user_account_presentation.register.RegisterScreen

fun NavGraphBuilder.userAccountNavigation(navController: NavController) {
    composable(Routes.userAccountAuthScreen.path, enterTransition = {
        EnterTransition.None
    }) {
        val context = LocalContext.current
        AuthScreen(
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
            }
        )
    }

    composable(Routes.userAccountRegisterScreen.path, enterTransition = {
        EnterTransition.None
    }) {
        val context = LocalContext.current
        RegisterScreen(
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
            }
        )
    }
}