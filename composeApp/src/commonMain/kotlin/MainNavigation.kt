import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.FunFactDetail
import screens.Home
import screens.Profile
import screens.TabNavigator
import utils.gradient_background
import utils.gradient_kashmir

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.TabNav.route,
        modifier =  Modifier.background(gradient_background)
    ) {
        composable(Routes.TabNav.route) {
            TabNavigator(navController)
        }
        composable(Routes.FactDetail.route) { backStackEntry ->
            val fact = navController.previousBackStackEntry?.savedStateHandle?.get<String>(Routes.FactDetail.route)
            FunFactDetail(navController, fact)
        }

    }
}