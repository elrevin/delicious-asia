package me.elrevin.onboarding_presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.elrevin.core.navigation.Routes
import me.elrevin.onboarding_presentation.screen.WelcomeScreen

fun NavGraphBuilder.onboardingNavGraph(navController: NavController) {
    navigation(route = Routes.onboardingRoot, startDestination = Routes.onboardingWelcomeScreen) {
        composable(Routes.onboardingWelcomeScreen) {
            WelcomeScreen(
                onStartCooking = {
                    navController.navigate(Routes.homeScreenRoot) {
                        popUpTo(Routes.onboardingRoot) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}