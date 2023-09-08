package me.elrevin.core

data class RoutePath (
    val path: String,
    val bottomNavigation: Boolean = false
)

object Routes {
    val onboardingRoot = RoutePath(path = "Onboarding")
    val onboardingWelcomeScreen = RoutePath(path = "WelcomeScreen")
    val userAccountAuthScreen = RoutePath(path = "AuthScreen")
    val userAccountRegisterScreen = RoutePath(path = "RegisterScreen")
    val homeScreenRoot = RoutePath(path = "HomeScreenRoot")
    val homeScreen = RoutePath(path = "HomeScreen")
}