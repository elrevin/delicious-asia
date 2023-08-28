package me.elrevin.deliciousasia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import me.elrevin.core.navigation.Routes
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.DeliciousAsiaTheme
import me.elrevin.home_screen_presentation.navigation.homeScreenNavigation
import me.elrevin.onboarding_presentation.navigation.onboardingNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DeliciousAsiaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.surface
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.onboardingRoot) {
                        onboardingNavGraph(navController = navController)
                        homeScreenNavigation(navController = navController)
                    }
                }
            }
        }
    }
}