package me.ppvan.metour.ui.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import me.ppvan.metour.MeTourApplication
import me.ppvan.metour.ui.page.HomePage
import me.ppvan.metour.ui.page.LibraryPage
import me.ppvan.metour.ui.page.ProfilePage
import me.ppvan.metour.ui.page.TourPage
import me.ppvan.metour.viewmodel.HomeViewModel
import me.ppvan.metour.viewmodel.viewModelFactory
import me.ppvan.moon.utils.SlideTransition


@Composable
fun HomeView(navigateToDetails: (Int) -> Unit) {

    var selectedPage by remember {
        mutableStateOf(TourPages.Home)
    }
    val homeViewModel = viewModel<HomeViewModel>(factory = viewModelFactory {
        HomeViewModel(MeTourApplication.appModule.tourRepo)
    })

    Scaffold(
        bottomBar = {
            MeTourNavigationBar(
                selectedPage = selectedPage,
                onPageSelected = { selectedPage = it }
            )
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { padding ->
        AnimatedContent(
            targetState = selectedPage,
            label = "page-navigation",
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .systemBarsPadding(),
            transitionSpec = {
                SlideTransition.slideUp.enterTransition()
                    .togetherWith(SlideTransition.slideDown.exitTransition())
            }

        )
        { page ->
            when (page) {
                TourPages.Home -> HomePage(homeViewModel, navigateToDetails)
                TourPages.Tour -> TourPage()
                TourPages.Profile -> ProfilePage()
                TourPages.Library -> LibraryPage()

                else -> {
                    Text(text = "UnImplemented")
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
    Library(icon = { Icons.Outlined.BookmarkBorder }, selectedIcon = { Icons.Filled.Bookmark }),
    Profile(icon = { Icons.Outlined.Person }, selectedIcon = { Icons.Filled.Person })
}
