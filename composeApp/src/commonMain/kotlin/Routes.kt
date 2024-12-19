sealed class Routes(val route: String) {
    data object Login : Routes("Login")
    data object SignUp : Routes("SignUp")
    data object TabNav : Routes("TabNav")
    data object Home : Routes("Home")
    data object Profile : Routes("Profile")
    data object Quiz : Routes("Quiz")
    data object FactDetail : Routes("FactDetail")
    data object ChildInfo : Routes("ChildInfo")
    data object ChildAutismDetail : Routes("ChildAutismDetail")
}