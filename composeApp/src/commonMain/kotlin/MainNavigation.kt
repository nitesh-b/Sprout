import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.FunFactDetail
import screens.Login
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
        startDestination = Routes.Login.route,
        modifier = Modifier.background(gradient_background)
    ) {
        composable(Routes.Login.route) {
            Login(navController, authViewModel)
        }
        composable(Routes.SignUp.route) {
            SignUp(navController, authViewModel)
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