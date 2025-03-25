package ch.fvj.mobpro.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ch.fvj.mobpro.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("HomeScreen", style = MaterialTheme.typography.headlineLarge)
        Button(
            onClick = {
                navController.navigate(Screen.User.route)
            }
        ) {
            Text("To Users")
        }
    }

}