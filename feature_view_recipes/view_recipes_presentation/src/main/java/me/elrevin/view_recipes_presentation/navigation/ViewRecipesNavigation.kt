package me.elrevin.view_recipes_presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.elrevin.core.Routes
import me.elrevin.view_recipes_presentation.screen.HomeScreen

fun NavGraphBuilder.viewRecipesNavigation(navController: NavController) {
    navigation(route = Routes.homeScreenRoot.path, startDestination = Routes.homeScreen.path) {
        composable(Routes.homeScreen.path) {
            HomeScreen()
        }
    }
}