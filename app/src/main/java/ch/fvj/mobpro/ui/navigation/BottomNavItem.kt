package ch.fvj.mobpro.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem (
    val label: String,
    val icon: ImageVector,
    val route: String
)

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
    object User : Screen("user")
}

object BottomNavItems {
    val list = listOf(
        BottomNavItem(label="Home", icon=Icons.Filled.Home, route="home"),
        BottomNavItem(label="Users", icon=Icons.Filled.AccountCircle, route="user"),
        BottomNavItem(label="Detail", icon=Icons.Default.Info, route="detail")

    )
}