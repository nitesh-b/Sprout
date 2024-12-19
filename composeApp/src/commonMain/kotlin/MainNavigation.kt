import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.ChildAutismDetail
import screens.ChildInfoScreen
import screens.FunFactDetail
import screens.Home
import screens.SignUp
import screens.TabNavigator
import utils.gradient_background
import viewmodels.AuthViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val authViewModel = viewModel { AuthViewModel() }

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
        modifier = Modifier.background(gradient_background)
    ) {
        composable(Routes.ChildInfo.route) {
            ChildInfoScreen(navController, authViewModel)
        }
        composable(Routes.ChildAutismDetail.route) {
            ChildAutismDetail(navController, authViewModel)
        }
        composable(Routes.SignUp.route) {
            SignUp(navController, authViewModel)
        }
        composable(Routes.Home.route) {
            Home(navController)
        }

        composable(Routes.TabNav.route) {
            TabNavigator(navController)
        }
        composable(Routes.FactDetail.route) { backStackEntry ->
            val fact =
                navController.previousBackStackEntry?.savedStateHandle?.get<String>(Routes.FactDetail.route)
            FunFactDetail(navController, fact)
        }

    }
}