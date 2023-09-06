package me.elrevin.onboarding_presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.elrevin.core.Routes
import me.elrevin.onboarding_presentation.screen.OnboardingScreen

fun NavGraphBuilder.onboardingNavGraph(navController: NavController) {
    navigation(route = Routes.onboardingRoot, startDestination = Routes.onboardingWelcomeScreen) {
        composable(Routes.onboardingWelcomeScreen) {
            OnboardingScreen(
                onStartCooking = {
                    navController.navigate(Routes.homeScreenRoot) {
                        popUpTo(Routes.onboardingRoot) {
                            inclusive = true
                        }
                    }
                },
                onLogin = {
                    navController.navigate(Routes.userAccountAuthScreen) {
                        popUpTo(Routes.onboardingRoot) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}