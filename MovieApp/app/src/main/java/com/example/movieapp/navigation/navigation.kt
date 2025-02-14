package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.DetailScreen
import com.example.movieapp.screens.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ){
        composable(MovieScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){
            backStruckEntry ->
            DetailScreen(navController = navController,backStruckEntry.arguments?.getString("movie") )
        }

    }
}