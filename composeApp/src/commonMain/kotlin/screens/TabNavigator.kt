package screens

import Routes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import components.Text
import isAndroid
import org.jetbrains.compose.ui.tooling.preview.Preview
import viewmodels.HomeViewModel


data class NavigationItem(val route: String, val label: String, val icon: ImageVector)

@Composable
@Preview
fun TabNavigator(rootNavController: NavHostController) {

    val homeViewModel = viewModel { HomeViewModel() }

    val tabNavController: NavHostController = rememberNavController()
    val bottomNavigationItems = listOf(
        NavigationItem(Routes.Home.route, "Home", Icons.Filled.Home),
        NavigationItem(Routes.Profile.route, "Profile", Icons.Filled.Settings)
    )

    LaunchedEffect(Unit) {
        homeViewModel.getHomeData()
    }
    Scaffold(

        bottomBar = {
            val baseModifier = Modifier.background(Color.Black).padding(top = 4.dp)
            val finalModifier =
                if (isAndroid()) baseModifier.padding(bottom = 20.dp) else baseModifier

            BottomNavigation(
                modifier = finalModifier,
                backgroundColor = Color.Black,
                contentColor = Color.White,
                elevation = 2.dp
            ) {
                val navBackStackEntry by tabNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavigationItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(text = screen.label, color = Color.White) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            tabNavController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(tabNavController.graph.findStartDestination().route!!) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        modifier = Modifier.background(Color.Transparent)
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = tabNavController,
            startDestination = Routes.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Routes.Home.route) { Home(tabNavController, homeViewModel) }
            composable(Routes.Profile.route) { Profile(rootNavController, tabNavController) }
        }
    }
}
