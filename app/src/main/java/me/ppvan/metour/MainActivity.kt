package me.ppvan.metour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import me.ppvan.metour.ui.page.HomePage
import me.ppvan.metour.ui.page.ProfilePage
import me.ppvan.metour.ui.page.TourPage
import me.ppvan.metour.ui.theme.MeTourTheme
import me.ppvan.moon.utils.SlideTransition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        mutableStateOf(TourPages.Home)
    }


    Scaffold(
        bottomBar = {
            MeTourNavigationBar(
                selectedPage = selectedPage,
                onPageSelected = { selectedPage = it })
        }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {
            AnimatedContent(
                targetState = selectedPage,
                label = "page-navigation",
                transitionSpec = {
                    SlideTransition.slideUp.enterTransition()
                        .togetherWith(SlideTransition.slideDown.exitTransition())
                }

            )
            { page ->
                when (page) {
                    TourPages.Home -> HomePage()
                    TourPages.Tour -> TourPage()
                    TourPages.Profile -> ProfilePage()

                    else -> {
                        Text(text = "UnImplemented")
                    }
                }

            }
        }
    }
}

@Composable
fun MeTourNavigationBar(
    selectedPage: TourPages,
    onPageSelected: (TourPages) -> Unit

) {

    NavigationBar {
        TourPages.values().forEach { page ->
            NavigationBarItem(
                selected = selectedPage == page,
                onClick = { onPageSelected(page) },
                label = { Text(text = page.name) },
                icon = {
                    if (selectedPage == page) {
                        Icon(imageVector = page.selectedIcon(), contentDescription = page.name)
                    } else {
                        Icon(imageVector = page.icon(), contentDescription = page.name)
                    }
                }
            )
        }
    }
}

enum class TourPages constructor(
    val icon: @Composable () -> ImageVector,
    val selectedIcon: @Composable () -> ImageVector
) {
    Home(icon = { Icons.Outlined.Home }, selectedIcon = { Icons.Filled.Home }),
    Tour(icon = { Icons.Outlined.Place }, selectedIcon = { Icons.Filled.Place }),
    Profile(icon = { Icons.Outlined.Person }, selectedIcon = { Icons.Filled.Person })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeTourTheme {
        MeTourApp()
    }
}