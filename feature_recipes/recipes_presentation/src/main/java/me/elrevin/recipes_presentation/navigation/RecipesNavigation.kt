package me.elrevin.recipes_presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.elrevin.core.Routes
import me.elrevin.recipes_presentation.home_screen.HomeScreen
import me.elrevin.recipes_presentation.home_screen.HomeScreenEvent
import me.elrevin.recipes_presentation.home_screen.HomeScreenVm

fun NavGraphBuilder.recipesNavigation(navController: NavController) {
    navigation(route = Routes.homeScreenRoot.path, startDestination = Routes.homeScreen.path) {
        composable(Routes.homeScreen.path) {
            val vm: HomeScreenVm = hiltViewModel()
            HomeScreen(
                state = vm.state,
                onActiveCategoryChange = { vm.onEvent( HomeScreenEvent.OnChangeActiveCategory(it) ) },
                onViewAllCategories = {}
            )
        }
    }
}