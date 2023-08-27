package me.elrevin.onboarding_presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.elrevin.onboarding_presentation.screen.WelcomeScreen

fun NavGraphBuilder.OnboardingNavGraph(navController: NavController) {
    navigation(route = "onboarding", startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(
                onStartCooking = {}
            )
        }
    }
}