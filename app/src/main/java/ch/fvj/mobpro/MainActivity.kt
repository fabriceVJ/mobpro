package ch.fvj.mobpro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ch.fvj.mobpro.ui.navigation.AppNavHost
import ch.fvj.mobpro.ui.navigation.BottomNav
import ch.fvj.mobpro.ui.theme.MobproTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobproTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize().padding(4.dp),
                    bottomBar = {BottomNav(navController = navController)}
                ) { innerPadding ->
                    AppNavHost(navController = navController, paddingValues = innerPadding)
                }
            }
        }
    }
}






