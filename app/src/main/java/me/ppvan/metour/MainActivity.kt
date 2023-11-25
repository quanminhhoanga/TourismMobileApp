package me.ppvan.metour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.ppvan.metour.ui.theme.MeTourTheme
import me.ppvan.metour.ui.view.HomeView
import me.ppvan.metour.ui.view.LoginView
import me.ppvan.metour.ui.view.RegisterView
import me.ppvan.metour.ui.view.TourDetailsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MeTourTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MeTourApp()
                }
            }
        }
    }
}

@Composable
fun MeTourApp() {

    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = Routes.Home.name) {
        composable(route = Routes.Home.name) {
            HomeView(navigateToDetails = { id -> navigator.navigate("${Routes.Tour.name}/${id}") })
        }
        composable(
            route = "${Routes.Tour.name}/{id}"
        ) { backStackEntry ->
            val id = backStackEntry.arguments.let {
                if (it == null) {
                    "1"
                } else {
                    it.getString("id", "1")
                }
            }
            TourDetailsView(id = id.toInt()) {
                navigator.popBackStack()
            }
        }
        composable(route = Routes.Register.name) {
            RegisterView()
        }

        composable(route = Routes.Login.name) {
            LoginView()
        }

    }

}

enum class Routes {
    Home, Tour, Register, Login
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeTourTheme {
        MeTourApp()
    }
}