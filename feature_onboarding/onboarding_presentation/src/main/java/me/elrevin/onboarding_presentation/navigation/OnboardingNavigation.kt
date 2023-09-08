package me.elrevin.onboarding_presentation.navigation

import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.coroutines.launch
import me.elrevin.core.Routes
import me.elrevin.onboarding_presentation.screen.OnboardingScreen

fun NavGraphBuilder.onboardingNavGraph(navController: NavController) {
    navigation(route = Routes.onboardingRoot.path, startDestination = Routes.onboardingWelcomeScreen.path) {
        composable(Routes.onboardingWelcomeScreen.path, exitTransition = {
            ExitTransition.None
        }) {
            OnboardingScreen(
                onStartCooking = {
                    navController.navigate(Routes.homeScreenRoot.path) {
                        popUpTo(Routes.onboardingRoot.path) {
                            inclusive = true
                        }
                    }
                },
                onLogin = {
                    navController.navigate(Routes.userAccountAuthScreen.path) {
                        popUpTo(Routes.onboardingRoot.path) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}