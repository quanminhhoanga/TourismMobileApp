package me.ppvan.metour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.ppvan.metour.ui.theme.MeTourTheme
import me.ppvan.metour.ui.view.HomeView
import me.ppvan.metour.ui.view.TourDetailsView
import me.ppvan.metour.ui.view.TourPages

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeTourApp() {
    var selectedPage by remember {
        mutableStateOf(TourPages.Profile)
    }
    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = "tour/0") {
        composable(route = "home") {
            HomeView(selectedPage = selectedPage, onPageSelected = { selectedPage = it })
        }
        composable(
            route = "tour/{id}",
            arguments = listOf(navArgument("id") { NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id", 1)!!
            TourDetailsView(id = id) {
                navigator.navigateUp()
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeTourTheme {
        MeTourApp()
    }
}