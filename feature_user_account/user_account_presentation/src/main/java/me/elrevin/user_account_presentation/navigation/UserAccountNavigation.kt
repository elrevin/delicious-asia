package me.elrevin.user_account_presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.elrevin.core.Routes
import me.elrevin.user_account_presentation.screen.AuthScreen

fun NavGraphBuilder.userAccountNavigation(navController: NavController) {
    composable(Routes.userAccountAuthScreen) {
        AuthScreen(
            onSuccessfulLogin = { /*TODO*/ },
            onRegister = { /*TODO*/ },
            onSkip = {}
        )
    }
}