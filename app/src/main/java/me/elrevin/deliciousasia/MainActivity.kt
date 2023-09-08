package me.elrevin.deliciousasia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.elrevin.core.Routes
import me.elrevin.core_ui.R as CoreUI
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.DeliciousAsiaTheme
import me.elrevin.onboarding_presentation.navigation.onboardingNavGraph
import me.elrevin.user_account_presentation.navigation.userAccountNavigation
import me.elrevin.view_recipes_presentation.navigation.viewRecipesNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DeliciousAsiaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.surface
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.onboardingRoot.path) {
                        onboardingNavGraph(navController = navController)
                        userAccountNavigation(navController = navController)
                        viewRecipesNavigation(navController = navController)
                    }
                }
            }
        }
    }
}