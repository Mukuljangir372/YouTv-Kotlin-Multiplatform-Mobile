package com.mukul.youtv.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mukul.youtv.android.features.ui_movie_list.MovieListScreen

private sealed class Screen(
    val route: String
) {
    object MovieList : Screen(route = "MovieList")
    object Search: Screen(route = "Search")
}

private sealed class NavScreen(
    private val route: String
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object MovieList: NavScreen(route = "MovieList")
    object Search: NavScreen(route = "Search")
}

@Composable
internal fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route,
        builder = {
            addMovieList(
                controller = navController,
                root = Screen.MovieList
            )
        }
    )
}

private fun NavGraphBuilder.addMovieList(
    controller: NavHostController,
    root: Screen
) {
    composable(
        route = Screen.MovieList.route,
        content = {
            MovieListScreen()
        }
    )
}























